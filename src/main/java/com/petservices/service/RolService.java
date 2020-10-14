package com.petservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petservices.dao.RolDAO;
import com.petservices.model.Rol;

@Service
public class RolService {
	
	@Autowired
	private RolDAO rolDao;
	
	 public List<Rol> listar(){
		 return rolDao.findAll();
	 }

}
