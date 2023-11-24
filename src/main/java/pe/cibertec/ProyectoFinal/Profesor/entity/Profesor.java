package pe.cibertec.ProyectoFinal.Profesor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Profesor {
    
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    
    private Long id;
    private Long codigo;
    private Long codigoP;
    private String nombre;
    private String apellido;
    private String sexo;
    private String edad;
    private String email;
    private String celular;
    
    
}
