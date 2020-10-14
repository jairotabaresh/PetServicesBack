package com.petservices.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petservices.dao.CitaDAO;
import com.petservices.model.Cita;

@Service
public class CitaService {
	
	@Autowired
	private CitaDAO citaDAO;
	
	public void guardar (Cita cita) {
		citaDAO.save(cita);
	}
	
	public void borrar (Cita cita) {
		citaDAO.delete(cita);
	}
	
	public List<Cita> obtenerCitas () {
		return citaDAO.findAll();
	}
	
	public List<Cita> obtenerCitaConIdUsuario (int idUsuario) {
		//TODO: este metodo no se puede usar desde el DAO
		return null;
	}
}
