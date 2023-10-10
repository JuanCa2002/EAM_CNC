package com.eam.proyectolinux.controllers;

import com.eam.proyectolinux.exceptions.PersonaExistenteException;
import com.eam.proyectolinux.exceptions.PersonaNoExistenteException;
import com.eam.proyectolinux.models.Persona;
import com.eam.proyectolinux.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping
    public ResponseEntity<?> createPersona(@RequestBody Persona persona){
        try {
          Persona personaAux = personaService.createPersona(persona);
          return ResponseEntity.ok(personaAux);
        }catch (PersonaExistenteException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Persona>> getAllPersonas(){
        List<Persona> personas = personaService.getAllPersonas();
        if(personas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(personas);
    }

    @GetMapping("{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable long id){
        Persona persona = personaService.getPersonaById(id);
        if(persona == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persona);
    }

    @GetMapping("/cedula/{cedula}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable String cedula){
        Persona persona = personaService.getPersonaByCedula(cedula);
        if(persona == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persona);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePersona(@PathVariable long id){
        try{
            Persona persona = personaService.deletePersona(id);
            return ResponseEntity.ok(persona);
        }catch (PersonaNoExistenteException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updatePersona(@PathVariable long id, @RequestBody Persona persona){
        try{
            Persona updatedPersona = personaService.updatePersona(id, persona);
            return ResponseEntity.ok(updatedPersona);
        }catch (PersonaNoExistenteException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
