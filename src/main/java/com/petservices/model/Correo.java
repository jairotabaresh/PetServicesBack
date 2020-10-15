package com.petservices.model;

public class Correo {
	
	private String nombre;
	private String correo;
	private String mascota;
	private String mensaje;
	private String correoDestino;
	
	
	
	public Correo() {
		this.correoDestino = "contactuspetservices@gmail.com";
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getMascota() {
		return mascota;
	}
	
	public void setMascota(String mascota) {
		this.mascota = mascota;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getCorreoDestino() {
		return correoDestino;
	}

	public void setCorreoDestino(String correoDestino) {
		this.correoDestino = correoDestino;
	}
	
}
