package com.petservices.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
			if(cita.getEstado().getId() == 0) {
				Estado estado = new Estado();
				estado.setId(1);
				cita.setEstado(estado);
			}
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
			List<Cita> citas = new ArrayList<Cita>();
			List<Cita> citaBD =  citaDAO.findAll();
			for(Cita cita :  citaBD) {
				if(cita.getMascota().getUsuario().getId() == idUsuario) {
					citas.add(cita);
				}
			}
			return citas;
	}
	
	public Optional<Cita> obtenerCitaConId (int id) {
		return citaDAO.findById(id);
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
