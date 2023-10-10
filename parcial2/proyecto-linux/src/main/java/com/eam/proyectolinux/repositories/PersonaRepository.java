package com.eam.proyectolinux.repositories;

import com.eam.proyectolinux.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    @Query("SELECT pe FROM Persona pe WHERE pe.cedula = :cedula")
    Persona getPersonaByCedula(String cedula);
}
