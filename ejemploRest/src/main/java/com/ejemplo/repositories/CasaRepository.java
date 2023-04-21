package com.ejemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.entities.Casa;

public interface CasaRepository extends JpaRepository<Casa, Long> {

}
