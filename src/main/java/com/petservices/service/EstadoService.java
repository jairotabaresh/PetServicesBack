package com.petservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petservices.dao.EstadoDAO;
import com.petservices.model.Estado;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoDAO estadoDAO;
	
	public List<Estado> Listar(){
		return estadoDAO.findAll();
	}
}
