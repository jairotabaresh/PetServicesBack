package com.petservices.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping ("/obtener/{id}")
	public Mascota obtenerConId (@PathVariable String id) {
		return mascotaService.obtenerMascotaConId(Integer.valueOf(id));
	}
	
	@PostMapping ("/crear")
	public boolean crear (@RequestBody Mascota mascota) {
		try {
			System.out.println("--Estoy creando una mascota--");
			mascotaService.guardar(mascota);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@GetMapping ("/listarPorUsuario/{id}")
	public List<Mascota> obtenerMascotaConIdUsuario (@PathVariable("id") int id) {
		System.out.print(id);
		List<Mascota> mascotas;
		try {
			mascotas = mascotaService.obtenerMascotaConIdUsuario(id);
			 return mascotas;
			
		}
		catch(Exception e) {
			mascotas = new ArrayList<Mascota>();
			return mascotas;
		}
	}
}
