package com.petservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.petservices.model.Correo;

@Service
public class ContactoService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	String subject = "Contacto";
	
	public void enviar(Correo correo) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(correo.getCorreoDestino());
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText("Nombre: " + correo.getNombre() + "\n" + 
								  "Correo: " + correo.getCorreo() + "\n" + 
								  "Mascota: " + correo.getMascota() + "\n" +
								  "Mensaje: " + correo.getMensaje());
		javaMailSender.send(simpleMailMessage);
		System.out.println("Enviado");
	}	
}