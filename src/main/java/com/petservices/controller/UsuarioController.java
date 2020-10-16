package com.petservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petservices.dao.UsuarioDAO;
import com.petservices.model.Usuario;
import com.petservices.service.UsuarioService;
import java.util.Optional;

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
		String contrasena = usuarioService.generarPassword();
		try {
			usuario.setContrasena(contrasena);
			usuarioService.guardar(usuario);
		return true;
		}catch(Exception e) {
			return false;
		}
	}

	@GetMapping(path = {"/editar/{id}"})
	public Optional<Usuario> obtenerId(@PathVariable("id") int id) {
		return usuarioService.obtenerUsuarioPorId(id);
	}
	
	@PostMapping("/iniciosesion")
	public Usuario  buscarUsuario(@RequestBody Usuario usuario) {
		
	
		
		return usuarioService.validarInfUsuario(usuario);
				
		
		
	}

	
	
	

	@PutMapping(path = {"/editar/{id}"})
	public Usuario actualizar(@RequestBody Usuario usuario, @PathVariable("id") int id) {
		usuario.setId(id);
		return usuarioService.actualizar(usuario);
	}

}
