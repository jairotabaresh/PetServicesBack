package com.petservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petservices.model.Cita;
import com.petservices.service.CitaService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping({"/citaController"})
public class CitaController {
	
	@Autowired
	private CitaService citaService;
	
	@GetMapping ("/listar")
	public List<Cita> listar () {
		return citaService.obtenerCitas();
	}
}
