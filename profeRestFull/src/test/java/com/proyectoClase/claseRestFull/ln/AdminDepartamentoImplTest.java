package com.proyectoClase.claseRestFull.ln;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyectoClase.claseRestFull.entities.Departamento;
import com.proyectoClase.claseRestFull.exceptions.CodeError;
import com.proyectoClase.claseRestFull.exceptions.ServicioException;
import com.proyectoClase.claseRestFull.repository.DepartamentoRepository;

@SpringBootTest
class AdminDepartamentoImplTest {

	@InjectMocks
	private AdminDepartamentoImpl adminDepartamento;

	@Mock
	private DepartamentoRepository repository;

	private Departamento departamento;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		departamento = new Departamento();
		departamento.setId(1);
		departamento.setNombre("RRHH");
	}

	@Test
	void testListDepartamentosSuccess() throws ServicioException {
		when(repository.findAll()).thenReturn(List.of(departamento));

		List<Departamento> result = adminDepartamento.listDepartamentos();

		assertNotNull(result);
		assertEquals(1, result.size());
		verify(repository).findAll();
	}

	@Test
	void testListDepartamentosException() {
		when(repository.findAll()).thenThrow(new RuntimeException("DB Error"));

		assertThrows(ServicioException.class, () -> adminDepartamento.listDepartamentos());
	}

	@Test
	void testConseguirDepartamentoSuccess() throws ServicioException {
		when(repository.findById(1)).thenReturn(Optional.of(departamento));

		Departamento result = adminDepartamento.conseguirDepartamento(1);

		assertNotNull(result);
		assertEquals("RRHH", result.getNombre());
	}

	@Test
	void testConseguirDepartamentoNotFound() {
		when(repository.findById(1)).thenReturn(Optional.empty());

		ServicioException ex = assertThrows(ServicioException.class, () -> adminDepartamento.conseguirDepartamento(1));
		assertEquals(CodeError.DEPARTAMENTO_NOT_FOUND, ex.getCodigo());
	}

	@Test
	void testGrabarDepartamentoSuccess() throws ServicioException {
		when(repository.save(any(Departamento.class))).thenReturn(departamento);

		Departamento result = adminDepartamento.grabarDepartamento(departamento);

		assertNotNull(result);
		assertEquals("RRHH", result.getNombre());
	}

	@Test
	void testGrabarDepartamentoException() {
		when(repository.save(any(Departamento.class))).thenThrow(new RuntimeException("DB Error"));

		assertThrows(ServicioException.class, () -> adminDepartamento.grabarDepartamento(departamento));
	}

	@Test
	void testEliminarDepartamentoSuccess() {
		assertDoesNotThrow(() -> adminDepartamento.eliminarDepartamento(1));
		verify(repository).deleteById(1);
	}

	@Test
	void testEliminarDepartamentoException() {
		doThrow(new RuntimeException("DB Error")).when(repository).deleteById(1);

		assertThrows(ServicioException.class, () -> adminDepartamento.eliminarDepartamento(1));
	}
}
