package com.proyectoClase.claseRestFull.api.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectoClase.claseRestFull.entities.Departamento;
import com.proyectoClase.claseRestFull.ln.AdminDepartamento;

@ExtendWith(MockitoExtension.class)
class DepartamentoControllerTest {


    private MockMvc mockMvc;

	@Mock
    private AdminDepartamento servicio;
	
	@InjectMocks
    private DepartamentoController controller;

    
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper = new ObjectMapper();
    }

    private Departamento getSampleDepartamento() {
        Departamento d = new Departamento();
        d.setId(1);
        d.setNombre("Finanzas");
        return d;
    }

    @Test
    void testListDepartamentos() throws Exception {
        when(servicio.listDepartamentos()).thenReturn(List.of(getSampleDepartamento()));

        mockMvc.perform(get("/api/departamentos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nombre").value("Finanzas"));
    }

//    @Test
//    void testFindDepartamento() throws Exception {
//        when(servicio.conseguirDepartamento(1)).thenReturn(getSampleDepartamento());
//
//        mockMvc.perform(get("/api/departamentos/{id}", 1))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.nombre").value("Finanzas"));
//    }

    @Test
    void testCreateDepartamento() throws Exception {
        Departamento d = getSampleDepartamento();
        when(servicio.grabarDepartamento(any(Departamento.class))).thenReturn(d);

        mockMvc.perform(post("/api/departamentos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(d)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Finanzas"));
    }

    @Test
    void testUpdateDepartamento() throws Exception {
        Departamento d = getSampleDepartamento();
        when(servicio.grabarDepartamento(any(Departamento.class))).thenReturn(d);

        mockMvc.perform(put("/api/departamentos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(d)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Finanzas"));
    }

//    @Test
//    void testDeleteDepartamento() throws Exception {
//        doNothing().when(servicio).eliminarDepartamento(1);
//
//        mockMvc.perform(delete("/api/departamentos/{id}", 1))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Se ha eliminado"));
//    }

    @Test
    void testListDepartamentosByRegion() throws Exception {
        when(servicio.listDepartamentosByIdRegion(1)).thenReturn(List.of(getSampleDepartamento()));

        mockMvc.perform(get("/api/departamentos/region"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nombre").value("Finanzas"));
    }
    
    @Test
    void testListDepartamentosByDireccion() throws Exception {
        when(servicio.listDepartamentosByIdDireccion(1700)).thenReturn(List.of(getSampleDepartamento()));

        mockMvc.perform(get("/api/departamentos/direccion"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nombre").value("Finanzas"));
    }
}
