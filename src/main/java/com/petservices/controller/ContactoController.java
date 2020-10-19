package com.petservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petservices.model.Correo;
import com.petservices.model.Usuario;
import com.petservices.service.ContactoService;

@CrossOrigin(origins="http://localhost:4200")

@RestController
@RequestMapping({"/contactoController"})
public class ContactoController {
	
	@Autowired
	private ContactoService contactoService;
	
	@PostMapping("/enviar")
	public boolean Crear(@RequestBody Correo correo) {
		try {
			contactoService.enviar(correo);
		return true;
		}catch(Exception e) {
			return false;
		}
	}	
	
	@PostMapping("/recuperar")
	public boolean Recuperar(@RequestBody Correo correo) {
		try {
			if(contactoService.recuperar(correo))
			{
				return true;
			}
			else
			{
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
	
	@PostMapping("/crearCorreo")
	public boolean crearCorreo(@RequestBody Correo correo) {
		try {
			contactoService.crearCorreo(correo);
		return true;
		}catch(Exception e) {
			return false;
		}
	}
}