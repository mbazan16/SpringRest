package com.proyectoClase.claseRestFull.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.proyectoClase.claseRestFull.entities.Region;

@RepositoryRestResource(path = "regiones", collectionResourceRel = "regiones")
public interface RegionRepository extends JpaRepository<Region,Integer> {
}
