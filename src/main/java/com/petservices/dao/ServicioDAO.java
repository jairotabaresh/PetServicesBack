package com.petservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petservices.model.Servicio;



public interface ServicioDAO extends JpaRepository <Servicio, Integer>{

}
