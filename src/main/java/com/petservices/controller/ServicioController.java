package com.petservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petservices.model.Servicio;
import com.petservices.service.ServicioService;

@CrossOrigin(origins="http://localhost:4200")

@RestController
@RequestMapping({"/servicioController"})
public class ServicioController {

	@Autowired
	private ServicioService servicioService;
	
	@GetMapping("/listar")
	public List<Servicio> listar(){
		return servicioService.Listar();
	}
	
}
