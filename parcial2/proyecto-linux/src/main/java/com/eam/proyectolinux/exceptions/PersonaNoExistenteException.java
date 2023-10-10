package com.eam.proyectolinux.exceptions;

public class PersonaNoExistenteException extends RuntimeException{

    public PersonaNoExistenteException(){
        super("La persona seleccionada no existe");
    }
}
