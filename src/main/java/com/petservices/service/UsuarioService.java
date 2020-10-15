package com.petservices.service;

import java.util.List;
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
	
	
	//Método validar usuario en base de datos y constraseña 
	public boolean buscarUsuario (Usuario usuario) {
		
		boolean resultado = false;
		String correo = usuario.getCorreo();
		String password = usuario.getContrasena();
		List<Usuario> usuarios;
		usuarios = usuarioDAO.findAll();
		
		for(Usuario item : usuarios) {
			
			
			
			if(correo.equals(item.getCorreo())) {
				resultado = true;
				break;
			}
			
			if(password.equals(item.getContrasena())) {
					resultado = true;
					break;
				}
											
		}
		
		return resultado;
		 
	}
}
