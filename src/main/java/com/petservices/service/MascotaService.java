package com.petservices.service;

import java.util.ArrayList;
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

	public List<Mascota> obtenerMascotaConIdUsuario(int idUsuario) {
		List<Mascota> mascotas = new ArrayList<Mascota>();
		List<Mascota> mascotaBdd =  mascotaDAO.findAll();
		for(Mascota mascota :  mascotaBdd) {
			if(mascota.getUsuario().getId() == idUsuario) {
				mascotas.add(mascota);
			}
		}
		return mascotas;
	}
}
