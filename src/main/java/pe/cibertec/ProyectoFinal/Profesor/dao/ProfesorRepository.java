package pe.cibertec.ProyectoFinal.Profesor.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.ProyectoFinal.Profesor.entity.Profesor;


public interface ProfesorRepository extends JpaRepository<Profesor, Long>{
    
    Optional<Profesor> findByNombre(String nombre);
    
}
