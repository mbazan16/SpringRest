package com.proyectoClase.claseRestFull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.proyectoClase.claseRestFull.entities.Pais;


@RepositoryRestResource(path = "paises", collectionResourceRel = "paises")
public interface PaisRepository extends JpaRepository<Pais,String> {
}
