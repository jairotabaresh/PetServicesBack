package com.petservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petservices.model.Usuario;

public interface UsuarioDAO extends JpaRepository <Usuario, Integer> {
	
}
