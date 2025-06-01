package co.unicauca.ra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AsignaturasCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsignaturasCursosApplication.class, args);
	}

}
