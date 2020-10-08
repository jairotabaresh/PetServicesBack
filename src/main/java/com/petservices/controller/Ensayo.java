package com.petservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petservices.dao.UsuarioDAO;
import com.petservices.model.Usuario;

@RestController
public class Ensayo {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@GetMapping ("/ensayo")
	public List<Usuario> ensayo () {
		
		List<Usuario> usuarios = usuarioDAO.findAll();
		return usuarios;
	}
}