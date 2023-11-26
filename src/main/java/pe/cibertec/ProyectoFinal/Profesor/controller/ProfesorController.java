package pe.cibertec.ProyectoFinal.Profesor.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ProyectoFinal.Profesor.dto.ProfesorDTO;
import pe.cibertec.ProyectoFinal.Profesor.entity.Profesor;
import pe.cibertec.ProyectoFinal.Profesor.exception.EntityNotFoundException;
import pe.cibertec.ProyectoFinal.Profesor.service.ProfesorService;

@RequestMapping("api/v1/profesor")
@RestController
@Slf4j

public class ProfesorController {

    @Autowired

    private ProfesorService profesorService;

    @GetMapping("/findAll")

    public ResponseEntity<List<Profesor>> findAll() {

        try {
            log.info("Endpoint: /api/v1/curso/findAll - Buscando todos los profesores");
            List<Profesor> profesores = profesorService.findAll();
            return new ResponseEntity<>(profesores, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al buscar todos los profesores: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/buscarPorId/{id}")

    public ResponseEntity<Profesor> buscarPorId(@PathVariable Long id) {

        try {
            log.info("Endpoint: /api/v1/curso/buscarPorId/{} - Buscando profesor por ID: {}", id, id);
            Profesor profesor = profesorService.buscarPorId(id);
            return new ResponseEntity<>(profesor, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al buscar profesor por ID {}: {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/findByCodigoP/{codigoP}")

    public ResponseEntity<Profesor> findByCodigoP(@PathVariable Long codigoP) {

        try {
            log.info("Endpoint: /api/v1/curso/findByCodigoP/{} - Buscando profesor por códigoP: {}", codigoP, codigoP);
            Profesor profesor = profesorService.findByCodigoP(codigoP);
            return new ResponseEntity<>(profesor, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al buscar profesor por códigoP {}: {}", codigoP, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/findByCodigo/{codigo}")

    public ResponseEntity<ProfesorDTO> findByCodigo(@PathVariable Long codigo) {

        try {
            log.info("Endpoint: /api/v1/curso/findByCodigo/{} - Buscando profesor y curso por código: {}", codigo, codigo);
            ProfesorDTO profesorDTO = profesorService.findById(codigo);
            return new ResponseEntity<>(profesorDTO, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al buscar profesor por código {}: {}", codigo, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/findByNombre/{nombre}")

    public ResponseEntity<Profesor> findByNombre(@PathVariable String nombre) {

        try {
            log.info("Endpoint: /api/v1/curso/findByNombre/{} - Buscando profesor por nombre: {}", nombre, nombre);
            Profesor profesor = profesorService.findByNombre(nombre);
            return new ResponseEntity<>(profesor, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al buscar profesor por nombre {}: {}", nombre, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/agregarProfesor")

    public ResponseEntity<Profesor> agregarProfesor(@RequestBody Profesor profesor) {

        try {
            log.info("Endpoint: /api/v1/curso/agregarProfesor - Agregando nuevo profesor: {}", profesor);
            Profesor nuevoProfesor = profesorService.agregarProfesor(profesor);
            return new ResponseEntity<>(nuevoProfesor, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error en la operación: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/actualizarProfesor")

    public ResponseEntity<Profesor> actualizarProfesor(@RequestBody Profesor profesor) {

        try {
            log.info("Endpoint: /api/v1/curso/actualizarProfesor - Actualizando profesor con ID {}: {}", profesor.getId(), profesor);
            Profesor profesorActualizado = profesorService.actualizarProfesor(profesor);
            return new ResponseEntity<>(profesorActualizado, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al actualizar profesor con ID {}: {}", profesor.getId(), e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/eliminarProfesor/{id}")

    public void eliminarProfesor(@PathVariable Long id) {

        try {
            log.info("Endpoint: /api/v1/curso/eliminarProfesor/{} - Eliminando profesor con ID: {}", id, id);
            profesorService.eliminarProfesor(id);
        } catch (EntityNotFoundException e) {
            log.error("Error al eliminar profesor con ID {}: {}", id, e.getMessage());
        }

    }

}
