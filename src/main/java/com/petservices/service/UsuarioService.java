package com.petservices.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.petservices.dao.UsuarioDAO;
import com.petservices.model.Usuario;

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
}
