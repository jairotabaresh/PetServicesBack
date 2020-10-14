package com.petservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petservices.model.Rol;
import com.petservices.service.RolService;

@CrossOrigin(origins="http://localhost:4200")

@RestController
@RequestMapping({"/rolController"})
public class RolController {
	
	@Autowired
	private RolService rolService;
	
	@GetMapping("/listar")
	public List<Rol> listar(){
		return rolService.listar();
	}
}
