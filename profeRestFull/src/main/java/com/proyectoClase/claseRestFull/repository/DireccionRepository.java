package com.proyectoClase.claseRestFull.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.proyectoClase.claseRestFull.entities.Direccion;


@RepositoryRestResource(path = "direcciones", collectionResourceRel = "direcciones")
public interface DireccionRepository extends JpaRepository<Direccion,Integer> {

	@RestResource(path="pais")
    List<Direccion> findAllByPais_Id(@Param("id") String idPais);
}
