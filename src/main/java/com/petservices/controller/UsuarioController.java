package com.petservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petservices.model.Usuario;
import com.petservices.service.UsuarioService;

@CrossOrigin(origins="http://localhost:4200")

@RestController
@RequestMapping({"/usuarioController"})
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping ("/listar")
	public List<Usuario> listar () {
		return usuarioService.obtenerUsuarios();
	}
	
	@PostMapping("/crear")
	public boolean Crear(@RequestBody Usuario usuario) {
		System.out.println("Entró en el servicio");
		System.out.println(usuario);
		try {
			usuario.setContrasena("123");
			usuarioService.guardar(usuario);
		return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	
}