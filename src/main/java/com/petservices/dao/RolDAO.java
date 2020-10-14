package com.petservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petservices.model.Rol;

public interface RolDAO extends JpaRepository <Rol, Integer>  {

}
