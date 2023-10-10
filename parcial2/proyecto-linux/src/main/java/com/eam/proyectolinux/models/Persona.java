package com.eam.proyectolinux.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private String apellido;

    private String cedula;

    private String correo;

    private String telefono;

}
