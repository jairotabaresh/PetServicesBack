package com.petservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petservices.model.Cita;

public interface CitaDAO extends JpaRepository<Cita, Integer> {

}
