package pe.cibertec.ProyectoFinal.Profesor.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.ProyectoFinal.Profesor.dao.ProfesorRepository;
import pe.cibertec.ProyectoFinal.Profesor.entity.Profesor;
import pe.cibertec.ProyectoFinal.Profesor.exception.EntityNotFoundException;
import pe.cibertec.ProyectoFinal.Profesor.service.ProfesorService;

@Service

public class ProfesorServiceImpl implements ProfesorService{
    
    @Autowired
    
    private ProfesorRepository profesorRepository;

    @Override
    public List<Profesor> findAll() {
       
        return (List<Profesor>) profesorRepository.findAll();
        
    }

    @Override
    public Profesor buscarPorId(Long id) {
       
     return profesorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Profesor no encontrado con el id"+id.toString()));
        
    }
    
     @Override
    public Profesor findByNombre(String nombre) {
        return profesorRepository.findByNombre(nombre).orElseThrow(() -> new EntityNotFoundException("Profesor no encontrado con el nombre"+nombre.toString()));
    }
    

    @Override
    public Profesor agregarProfesor(Profesor profesor) {
        
        return profesorRepository.save(profesor);
        
    }

    @Override
    public Profesor actualizarProfesor(Profesor profesor) {
       
        var ProfesorF = profesorRepository.findById(profesor.getId()).get();
        ProfesorF.setNombre(profesor.getNombre());
        ProfesorF.setApellido(profesor.getApellido());
        ProfesorF.setSexo(profesor.getSexo());
        ProfesorF.setEdad(profesor.getEdad());
        ProfesorF.setEmail(profesor.getEmail());
        ProfesorF.setCelular(profesor.getCelular());
        
        return profesorRepository.save(ProfesorF);
        
        
    }

    @Override
    public void eliminarProfesor(Long id) {
        
        var ProfesorF = profesorRepository.findById(id).get();
        
        profesorRepository.delete(ProfesorF);
        
        
    }

    
}
