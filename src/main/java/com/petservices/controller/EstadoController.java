package com.petservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petservices.model.Estado;
import com.petservices.service.EstadoService;


@CrossOrigin(origins="http://localhost:4200")

@RestController
@RequestMapping({"/estadoController"})
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping("/listar")
	public List<Estado> listar(){
		return estadoService.Listar();
	}
}

