package com.petservices.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "cita")
public class Cita {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private Date fecha;
	@Column
	private Time hora;
	@Column
	private String comentario;
	
	@ManyToOne
	@JoinColumn(name = "IdMascota")
	private Mascota mascota;
	
	@ManyToOne
	@JoinColumn(name = "IdSevicio")
	private Servicio servicio;
	
	@ManyToOne
	@JoinColumn(name = "IdEstado")
	private Estado estado;
}
