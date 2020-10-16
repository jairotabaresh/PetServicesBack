package com.petservices.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petservices.dao.UsuarioDAO;
import com.petservices.model.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public void guardar (Usuario usuario) {
		usuarioDAO.save(usuario);
	}
	
	public void borrar (Usuario usuario) {
		usuarioDAO.delete(usuario);
	}
	
	public List<Usuario> obtenerUsuarios () {
		return usuarioDAO.findAll();
	}
	
	public Optional<Usuario> obtenerUsuarioPorId(int id) {
		return usuarioDAO.findById(id);
	}
	
	public Usuario actualizar (Usuario usuario) {
		return usuarioDAO.save(usuario);
	}
	
	public String generarPassword() {		
		String password = RandomStringUtils.randomAscii(10);
		return password;
	}
}
