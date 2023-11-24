package pe.cibertec.ProyectoFinal.Profesor.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.ProyectoFinal.Profesor.dao.ProfesorRepository;
import pe.cibertec.ProyectoFinal.Profesor.dto.ProfesorDTO;
import pe.cibertec.ProyectoFinal.Profesor.entity.Curso;
import pe.cibertec.ProyectoFinal.Profesor.entity.Profesor;
import pe.cibertec.ProyectoFinal.Profesor.exception.EntityNotFoundException;
import pe.cibertec.ProyectoFinal.Profesor.service.ProfesorService;
import pe.cibertec.ProyectoFinal.Profesor.restClient.CursoRestClient;

@Service

public class ProfesorServiceImpl implements ProfesorService {

    @Autowired

    private ProfesorRepository profesorRepository;

    @Autowired

    private CursoRestClient apiRestClient;

    @Override
    public List<Profesor> findAll() {

        return (List<Profesor>) profesorRepository.findAll();

    }

    public List<Curso> findAllCurso() {
        
        return (List<Curso>) apiRestClient.findAllCurso();
        
    }
    
    @Override
    public Profesor buscarPorId(Long id) {

        return profesorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Profesor no encontrado con el id" + id.toString()));

    }

    @Override
    public Profesor findByNombre(String nombre) {
        return profesorRepository.findByNombre(nombre).orElseThrow(() -> new EntityNotFoundException("Profesor no encontrado con el nombre" + nombre.toString()));
    }

    @Override
    public Profesor agregarProfesor(Profesor profesor) {

        return profesorRepository.save(profesor);

    }

    @Override
    public Profesor actualizarProfesor(Profesor profesor) {

        var ProfesorF = profesorRepository.findById(profesor.getId()).get();
        ProfesorF.setCodigoP(profesor.getCodigoP());
        ProfesorF.setCodigo(profesor.getCodigo());
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

    @Override
    public ProfesorDTO findById(Long id) {

        Profesor profesor = profesorRepository.findById(id).get();

        Curso curso = apiRestClient.findByCodigo(profesor.getCodigo());

        ProfesorDTO profesorDTO = new ProfesorDTO();

        profesorDTO.setId(profesor.getId());
        profesorDTO.setCodigoP(profesor.getCodigoP());
        profesorDTO.setNombre(profesor.getNombre());
        profesorDTO.setApellido(profesor.getApellido());
        profesorDTO.setSexo(profesor.getSexo());
        profesorDTO.setEdad(profesor.getEdad());
        profesorDTO.setEmail(profesor.getEmail());
        profesorDTO.setCelular(profesor.getCelular());
        profesorDTO.setCurso(curso);

        return profesorDTO;

    }

    @Override
    public Profesor findByCodigoP(Long codigoP) {
        
        return profesorRepository.findByCodigoP(codigoP).orElseThrow(() -> new EntityNotFoundException("Profesor no encontrado con el codigo"+codigoP.toString()));
        
    }

}
