package pe.cibertec.ProyectoFinal.Profesor.controller;

import java.util.List;
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
import pe.cibertec.ProyectoFinal.Profesor.entity.Profesor;
import pe.cibertec.ProyectoFinal.Profesor.service.ProfesorService;

@RequestMapping("/api/v1/profesor")
@RestController

public class ProfesorController {

    @Autowired

    private ProfesorService profesorService;

    @GetMapping("/findAll")

    public ResponseEntity<List<Profesor>> findAll() {

        return new ResponseEntity<>(profesorService.findAll(), HttpStatus.OK);

    }

    @GetMapping("/buscarPorId/{id}")

    public ResponseEntity<Profesor> buscarPorId(@PathVariable Long id) {

        return new ResponseEntity<>(profesorService.buscarPorId(id), HttpStatus.OK);

    }

    @GetMapping("/findByNombre/{nombre}")

    public ResponseEntity<Profesor> findByNombre(@PathVariable String nombre) {

        return new ResponseEntity<>(profesorService.findByNombre(nombre), HttpStatus.OK);

    }

    @PostMapping("/agregarProfesor")

    public ResponseEntity<Profesor> agregarProfesor(@RequestBody Profesor profesor) {

        return new ResponseEntity<>(profesorService.agregarProfesor(profesor), HttpStatus.CREATED);

    }

    @PutMapping("/actualizarProfesor")

    public ResponseEntity<Profesor> actualizarProfesor(@RequestBody Profesor profesor) {

        return new ResponseEntity<>(profesorService.actualizarProfesor(profesor), HttpStatus.OK);

    }

    @DeleteMapping("/eliminarProfesor/{id}")

    public void eliminarProfesor(@PathVariable Long id) {

        profesorService.eliminarProfesor(id);

    }

}
