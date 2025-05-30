package co.unicauca.ra.servicio_rubricas.fachadaServices.DTO;

import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriterioDTORespuesta {
    private String descripcion;
    private List<NivelDTORespuesta> niveles;
}