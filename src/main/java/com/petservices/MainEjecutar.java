package com.petservices;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.petservices.dao.CitaDAO;
import com.petservices.dao.MascotaDAO;
import com.petservices.dao.UsuarioDAO;
import com.petservices.model.Cita;
import com.petservices.model.Mascota;
import com.petservices.model.Usuario;

@Component
public class MainEjecutar {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	@Autowired
	private CitaDAO citaDAO;
	@Autowired
	private MascotaDAO mascotaDAO;
	
	public void ejecutar () {
		
		System.out.println("=========Usuarios=========");
		List<Usuario> usuarios = usuarioDAO.findAll();
		
		for (Usuario usuario: usuarios) {
			System.out.println(usuario.getId());
			System.out.println(usuario.getNombre());
			System.out.println(usuario.getCelular());
			System.out.println(usuario.getCorreo());
			System.out.println(usuario.getDireccion());
			System.out.println(usuario.getContrasena());
			
			System.out.println("rol: id-" + usuario.getRol().getId() + " rol-" + usuario.getRol().getNombre());
			System.out.println();
		}
		
		System.out.println("=========Mascotas=========");
		List<Mascota> mascotas = mascotaDAO.findAll();
		
		for(Mascota mascota: mascotas) {
			System.out.println(mascota.getId());
			System.out.println(mascota.getEspecie());
			System.out.println(mascota.getRaza());
			System.out.println(mascota.getNombre());
			System.out.println(mascota.getEdad());
			
			System.out.println("usuario: id-" + mascota.getUsuario().getId() + 
					" nombre-" + mascota.getUsuario().getNombre() + " celular-" + mascota.getUsuario().getCelular() +
					" correo-" + mascota.getUsuario().getCorreo() + " direccion-" + mascota.getUsuario().getDireccion() +
					" contrasena-" + mascota.getUsuario().getContrasena());
			
			System.out.println("rol: id-" + mascota.getUsuario().getRol().getId() + " rol-" + 
			mascota.getUsuario().getRol().getNombre());
			System.out.println();
		}
		
		System.out.println("==========Citas==========");
		List<Cita> citas = citaDAO.findAll();
		
		for(Cita cita: citas) {
			System.out.println(cita.getId());
			System.out.println(cita.getFecha());
			System.out.println(cita.getHora());
			System.out.println(cita.getComentario());
			
			System.out.println("mascota: id-" + cita.getMascota().getId() + " especie-" + cita.getMascota().getEspecie() + 
					" raza-" + cita.getMascota().getRaza() + " nombre-" + cita.getMascota().getNombre() + " edad-" + 
					cita.getMascota().getEdad());
			
			System.out.println("usuario: id-" + cita.getMascota().getUsuario().getId() + 
					" nombre-" + cita.getMascota().getUsuario().getNombre() + " celular-" + cita.getMascota().getUsuario().getCelular() +
					" correo-" + cita.getMascota().getUsuario().getCorreo() + " direccion-" + cita.getMascota().getUsuario().getDireccion() +
					" contrasena-" + cita.getMascota().getUsuario().getContrasena());
			
			System.out.println("rol: id-" + cita.getMascota().getUsuario().getRol().getId() + " rol-" + 
			cita.getMascota().getUsuario().getRol().getNombre());
			System.out.println("estado: id-" + cita.getEstado().getId() + " nombre-" + cita.getEstado().getNombre());
			System.out.println("servicio: id-" + cita.getServicio().getId() + " nombre-" + cita.getServicio().getNombre());
			System.out.println();
		}
	}
}
