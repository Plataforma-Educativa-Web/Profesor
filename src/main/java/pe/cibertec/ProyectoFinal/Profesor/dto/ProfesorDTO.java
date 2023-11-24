package pe.cibertec.ProyectoFinal.Profesor.dto;

import lombok.Data;
import pe.cibertec.ProyectoFinal.Profesor.entity.Curso;

@Data

public class ProfesorDTO {

    private Long id;
    private Long codigoP;
    private String nombre;
    private String apellido;
    private String sexo;
    private String edad;
    private String email;
    private String celular;
    private Curso curso;

}
