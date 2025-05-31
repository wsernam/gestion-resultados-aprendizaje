package co.unicauca.servicioracompetencias.fachadaServices.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RAAsignaturaDTORespuesta {
    private String id;
    private String competenciaAsignaturaId;
    private String nombre;
    private String descripcion;
}