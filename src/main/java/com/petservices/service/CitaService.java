package com.petservices.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petservices.dao.CitaDAO;
import com.petservices.model.Cita;
import com.petservices.model.Estado;

@Service
public class CitaService {
	
	@Autowired
	private CitaDAO citaDAO;
	
	public boolean guardar (Cita cita) {
		
		if(!validarFechaYHora(cita.getFecha(),cita.getHora()))
		{
			Estado estado = new Estado();
			estado.setId(1);
			cita.setEstado(estado);
			citaDAO.save(cita);
			return true;
		}else {
			return false;
		}
		
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
	
	private boolean validarFechaYHora(Date fecha, Time hora) {
		List<Cita> citas = citaDAO.findAll();
		
		for (Cita cita : citas) {
			if (cita.getFecha() == fecha && cita.getHora() == hora ) {
				return true;
			}
		}
		return false;
	}
}
