package com.example.demo.data;


public class Departamento {
	
	
	private Integer id;
	private String nombre;
	private Integer direccionId;
	private Integer managerId;
	
	public Departamento() {
		super();
	}
	
	

	public Departamento(Integer id, String nombre, Integer direccionId, Integer managerId) {
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
