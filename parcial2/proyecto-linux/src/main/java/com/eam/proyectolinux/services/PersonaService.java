package com.eam.proyectolinux.services;

import com.eam.proyectolinux.exceptions.PersonaExistenteException;
import com.eam.proyectolinux.exceptions.PersonaNoExistenteException;
import com.eam.proyectolinux.models.Persona;
import com.eam.proyectolinux.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public Persona createPersona(Persona persona) throws PersonaExistenteException{
        Persona personaAux = getPersonaByCedula(persona.getCedula());
        if(personaAux != null){
            throw new PersonaExistenteException();
        }
        return personaRepository.save(persona);
    }

    public Persona getPersonaByCedula(String cedula){
        Persona persona = personaRepository.getPersonaByCedula(cedula);
        if(persona == null){
            return null;
        }
        return persona;
    }

    public Persona getPersonaById(long id){
        return personaRepository.findById(id).orElse(null);
    }

    public List<Persona> getAllPersonas(){
        List<Persona> personas = personaRepository.findAll();
        if(personas.isEmpty()){
            return null;
        }
        return personas;
    }

    public Persona deletePersona(long id) throws PersonaNoExistenteException{
        Persona persona = getPersonaById(id);
        if(persona== null){
           throw new PersonaNoExistenteException();
        }
        personaRepository.delete(persona);
        return persona;
    }

    public Persona updatePersona(long id, Persona persona) throws PersonaNoExistenteException{
        Persona currentPersona = getPersonaById(id);
        if(persona == null){
            throw new PersonaNoExistenteException();
        }
        currentPersona.setNombre(persona.getNombre());
        currentPersona.setApellido(persona.getApellido());
        currentPersona.setCorreo(persona.getCorreo());
        currentPersona.setTelefono(persona.getTelefono());
        return personaRepository.save(currentPersona);
    }
}
