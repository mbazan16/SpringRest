package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DEPARTMENTS")
public class Department {
	
	@Id
	@Column(name="DEPARTMENT_ID")
	private Integer id;
	@Column(name="DEPARTMENT_NAME")
	private String nombre;
	@Column(name="LOCATION_ID")
	private Integer direccionId;
	@Column(name="MANAGER_ID")
	private Integer managerId;
	
	
	public Department() {
		super();
	}


	public Department(Integer id, String nombre, Integer direccionId, Integer managerId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccionId = direccionId;
		this.managerId = managerId;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getDireccionId() {
		return direccionId;
	}


	public void setDireccionId(Integer direccionId) {
		this.direccionId = direccionId;
	}


	public Integer getManagerId() {
		return managerId;
	}


	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}


	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre + ", direccionId=" + direccionId + ", managerId="
				+ managerId + "]";
	}
	
	

}
