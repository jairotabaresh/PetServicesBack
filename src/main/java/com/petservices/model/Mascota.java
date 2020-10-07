package com.petservices.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mascota")
public class Mascota {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String especie;
	@Column
	private String raza;
	@Column
	private String nombre;
	@Column
	private int edad;
	
	@ManyToOne
	@JoinColumn(name = "IdUsuario")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "mascota")
	private List<Cita> citas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
