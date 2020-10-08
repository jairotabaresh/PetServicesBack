package com.petservices;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.petservices.dao.UsuarioDAO;
import com.petservices.model.Usuario;

@Component
public class MainEjecutar {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public void ejecutar () {
		
		List<Usuario> usuarios = usuarioDAO.findAll();
		
		for (Usuario usuario: usuarios) {
			System.out.println(usuario.getId());
			System.out.println(usuario.getCelular());
			System.out.println(usuario.getCorreo());
			System.out.println(usuario.getDireccion());
			System.out.println(usuario.getNombre());
			System.out.println(usuario.getContrasena());
		}
	}
}
