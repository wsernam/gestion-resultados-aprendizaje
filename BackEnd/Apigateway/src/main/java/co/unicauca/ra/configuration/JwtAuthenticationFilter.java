/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.ra.configuration;

/**
 *
 * @author ashle
 */
import co.unicauca.ra.configuration.JwtUtil;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationFilter extends AbstractGatewayFilterFactory<JwtAuthenticationFilter.Config> {

    @Autowired
    private JwtUtil jwtUtil;


    public JwtAuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String path = request.getURI().getPath();
            String method = request.getMethod().name();

            // rutas públicas
            if ((path.startsWith("/api/login") || path.startsWith("/api/docentes/guardar") || path.startsWith("/api/evaluadores/guardar")) && method.equalsIgnoreCase("POST")) {
                return chain.filter(exchange);
            }
            //header contains token or not
            if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
               return unauthorized(exchange, "Acceso denegado: se requiere token de autorizacion");
            }

            String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                authHeader = authHeader.substring(7);
            }

            try {
//                    
                jwtUtil.validateToken(authHeader);

                List<String> roles = jwtUtil.extractRoles(authHeader);

                if ((path.startsWith("/api/docentes/listar") || path.startsWith("/api/evaluadores/listar")) && !roles.contains("COORDINADOR")) {
                    return unauthorized(exchange, "Acceso denegado: requiere rol COORDINADOR");
                }
                if (  path.startsWith("/api/docentes/**") && !roles.contains("DOCENTE")) {
                    return unauthorized(exchange, "Acceso denegado: requiere rol DOCENTE");
                }
                
                if (  path.startsWith("/api/evaluadores/**") && !roles.contains("EVALUADOR")) {
                    return unauthorized(exchange, "Acceso denegado: requiere rol EVALUADOR");
                }
                if (path.startsWith("/api/cursos/**") && !roles.contains("DOCENTE")) {
                    return unauthorized(exchange, "Acceso denegado: requiere rol DOCENTE");
                }
                if (path.startsWith("/api/asignaturas/**") && !roles.contains("DOCENTE")) {
                    return unauthorized(exchange, "Acceso denegado: requiere rol DOCENTE");
                }
                if (path.startsWith("/api/rubricas/**") && !roles.contains("DOCENTE")) {
                    return unauthorized(exchange, "Acceso denegado: requiere rol DOCENTE");
                }
                if ((path.startsWith("/api/RAAsignatura/**") || path.startsWith("/api/competenciasAsignatura/**") && method.equalsIgnoreCase("POST")) && !roles.contains("DOCENTE")) {
                    return unauthorized(exchange, "Acceso denegado: requiere rol DOCENTE");
                }
                
                if ((path.startsWith("/api/RAPrograma/**") || path.startsWith("/api/competenciasPrograma/**") && method.equalsIgnoreCase("POST")) && !roles.contains("COORDINADOR")) {
                    return unauthorized(exchange, "Acceso denegado: requiere rol COORDINADOR");
                }
                
            } catch (Exception e) {
                return unauthorized(exchange, "Token inválido o expirado");
            }

            return chain.filter(exchange);
        });
    }

    private Mono<Void> unauthorized(ServerWebExchange exchange, String message) {
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        DataBuffer buffer = exchange.getResponse()
                .bufferFactory()
                .wrap(message.getBytes(StandardCharsets.UTF_8));
        return exchange.getResponse().writeWith(Mono.just(buffer));
    }

   

    public static class Config {

    }

}
