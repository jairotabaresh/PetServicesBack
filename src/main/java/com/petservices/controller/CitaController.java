package com.petservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petservices.model.Cita;
import com.petservices.model.Usuario;
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
	
	@PostMapping("/crear")
	public boolean Crear(@RequestBody Cita cita) {
		try {
			citaService.guardar(cita);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
