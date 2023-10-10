package com.eam.proyectolinux.exceptions;

public class PersonaExistenteException extends RuntimeException{

    public PersonaExistenteException(){
        super("Este persona ya se encuentra registrada en el sistema");
    }
}
