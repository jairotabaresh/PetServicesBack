package com.petservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.petservices.dao.UsuarioDAO;
import com.petservices.model.Correo;
import com.petservices.model.Usuario;

@Service
public class ContactoService {

	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private UsuarioDAO usuarioDAO;

	String subject = "Contacto";
	String subjectenvio = "Recuperación de contraseña";
	String subjectNuevo = "Bienvenido a PetServices";

	public void enviar(Correo correo) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(correo.getCorreoDestino());
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText("Nombre: " + correo.getNombre() + "\n" + "Correo: " + correo.getCorreo() + "\n"
				+ "Mascota: " + correo.getMascota() + "\n" + "Mensaje: " + correo.getMensaje());
		javaMailSender.send(simpleMailMessage);
		System.out.println("Enviado");
	}

	public boolean recuperar(Correo correo) {
		List<Usuario> usuarios;
		usuarios = usuarioDAO.findAll();
		for (Usuario item : usuarios) {
			if (item.getCorreo().equals(correo.getCorreo())) {
				SimpleMailMessage simpleMailMessagerecuperacion = new SimpleMailMessage();
				simpleMailMessagerecuperacion.setTo(correo.getCorreo());
				simpleMailMessagerecuperacion.setSubject(subjectenvio);
				simpleMailMessagerecuperacion.setText("Contraseña: " + item.getContrasena());
				javaMailSender.send(simpleMailMessagerecuperacion);
				System.out.println("Enviado");
				return true;
			}
		}
		return false;
	}

	public boolean correoRegistro(String correo) {
		List<Usuario> usuarios;
		usuarios = usuarioDAO.findAll();
		for (Usuario item : usuarios) {
			if (item.getCorreo().equals(correo)) {
				SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
				simpleMailMessage.setTo(correo);
				simpleMailMessage.setSubject(subjectNuevo);
				simpleMailMessage.setText("Bienvenido a PetServices, " + item.getNombre() + 
										  "\nSu usuario se ha creado exitosamente.\n" + 
										  "\nCorreo: " + item.getCorreo() + "\n" + 
										  "Contraseña: " + item.getContrasena());
				javaMailSender.send(simpleMailMessage);
				System.out.println("Enviado");
				return true;
			}
		}
		return false;
	}
}