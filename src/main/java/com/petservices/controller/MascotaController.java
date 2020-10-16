package com.petservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petservices.model.Mascota;
import com.petservices.service.MascotaService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping({"/mascotaController"})
public class MascotaController {
	
	@Autowired
	private MascotaService mascotaService;
	
	@GetMapping ("/listar")
	public List<Mascota> listar () {
		return mascotaService.obtenerMascotas();
	}
	
	@PostMapping ("/crear")
	public boolean crear (@RequestBody Mascota mascota) {
		try {
			System.out.println("Estoy creando una mascota");
			mascotaService.guardar(mascota);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}