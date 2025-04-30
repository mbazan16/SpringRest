package com.proyectoClase.claseRestFull.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="DEPARTMENTS")
public class Departamento {
	
	private @Id @Column(name="DEPARTMENT_ID")
	Integer id;
	@Column(name="DEPARTMENT_NAME") 
	private String nombre;
	@Column(name="MANAGER_ID") private String idGestor;
	
	@ManyToOne
	@JoinColumn(name="LOCATION_ID")
	private Direccion direccion;

}
