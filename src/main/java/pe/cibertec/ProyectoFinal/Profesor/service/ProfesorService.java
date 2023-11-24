package pe.cibertec.ProyectoFinal.Profesor.service;

import java.util.List;
import pe.cibertec.ProyectoFinal.Profesor.dto.ProfesorDTO;
import pe.cibertec.ProyectoFinal.Profesor.entity.Profesor;

public interface ProfesorService {

    public List<Profesor> findAll();

    public Profesor buscarPorId(Long id);

    public Profesor findByCodigoP (Long codigoP);
    
    public ProfesorDTO findById(Long id);

    public Profesor findByNombre(String nombre);

    public Profesor agregarProfesor(Profesor profesor);

    public Profesor actualizarProfesor(Profesor profesor);

    public void eliminarProfesor(Long id);

}
