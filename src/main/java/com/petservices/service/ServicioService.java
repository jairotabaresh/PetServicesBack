package com.petservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petservices.dao.ServicioDAO;
import com.petservices.model.Servicio;

@Service
public class ServicioService {
	
	@Autowired
	private ServicioDAO servicioDAO;
	
	public List<Servicio> Listar(){
		return servicioDAO.findAll();
	}

}
