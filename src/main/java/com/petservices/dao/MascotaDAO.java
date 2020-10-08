package com.petservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petservices.model.Mascota;

public interface MascotaDAO extends JpaRepository <Mascota, Integer> {	
	
}
