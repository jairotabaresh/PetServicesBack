package com.petservices.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petservices.dao.MascotaDAO;
import com.petservices.model.Mascota;

@Service
public class MascotaService {
	
	@Autowired
	private MascotaDAO mascotaDAO;
	
	public void guardar (Mascota mascota) {
		mascotaDAO.save(mascota);
	}
	
	public void borrar (Mascota mascota) {
		mascotaDAO.delete(mascota);
	}
	
	public List<Mascota> obtenerMascotas () {
		return mascotaDAO.findAll();
	}
	
	public List<Mascota> obtenerCitaConIdUsuario (int idUsuario) {
		//TODO: este metodo no se puede usar desde el DAO
		return null;
	}
}
