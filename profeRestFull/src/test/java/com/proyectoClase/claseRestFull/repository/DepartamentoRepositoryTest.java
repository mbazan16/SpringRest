package com.proyectoClase.claseRestFull.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.proyectoClase.claseRestFull.entities.Departamento;
import com.proyectoClase.claseRestFull.entities.Direccion;
import com.proyectoClase.claseRestFull.entities.Pais;
import com.proyectoClase.claseRestFull.entities.Region;


@DataJpaTest
class DepartamentoRepositoryTest {
	
	Logger log = LoggerFactory.getLogger(DepartamentoRepositoryTest.class);
	
	@Autowired
	DepartamentoRepository repositorio;
	
	
	
	@BeforeEach
	void cargarDatos() {
//		Region region = new Region();
//		region.setId(6);
//		region.setNombre("Atlantida");
//		
//	
//		
//		Pais pais = new Pais();
//		pais.setId("ES");
//		pais.setNombre("ESPAÑA");
//		pais.setRegion(region);
//		
//		Direccion direccion = new Direccion();
//		direccion.setId(6700);
//		direccion.setPais(pais);
//		
//		
//		Departamento departamento = new Departamento();
//		departamento.setId(1000);
//		departamento.setNombre("PRUEBA");
//		departamento.setDireccion(direccion);	
//		
//		
//		repositorio.save(departamento);
	}

	@Test
	@DisplayName("findByNombre_OK")
	void findByNombreOk() {
		
		Optional<Departamento> departamento = repositorio.findByNombre("Finanzas");
		
		assertEquals(departamento.isPresent(), true);	
		assertEquals(departamento.get().getId(), 50);		
		
		
	}
	
	@Test
	@DisplayName("findByNombre_KO")
	void findByNombreko() {
		
		Optional<Departamento> departamento = repositorio.findByNombre(null);
		
		assertEquals(departamento.isPresent(), false);		
		
		
	}
	
	@Test
	@DisplayName("findByIdRegion_OK")
	void findByIdRegion_OK() {
		log.info("[findByIdRegion_OK");
		List<Departamento> departamentos = repositorio.findByIdRegion(1);
		log.info("DEPARTAMENTOS:"+ departamentos);
		
				
		assertEquals(false, departamentos.isEmpty());	
		assertEquals( 4,departamentos.size());		
		
		
	}
	
	@Test
	@DisplayName("findByIdRegion_KO")
	void findByIdRegion_KO() {
		log.info("[findByIdRegion_OK");
		List<Departamento> departamentos = repositorio.findByIdRegion(null);
		log.info("DEPARTAMENTOS:"+ departamentos);
		
				
		assertEquals(true, departamentos.isEmpty());	
		assertEquals( 0,departamentos.size());		
		
		
	}
	
	
	@AfterEach
	void eliminarDatos() {
//		Departamento departamento = new Departamento();
//		departamento.setId(1000);
//		departamento.setNombre("PRUEBA");		
//		repositorio.delete(departamento);
	}
	

}
