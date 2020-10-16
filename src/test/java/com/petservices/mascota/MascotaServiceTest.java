package com.petservices.mascota;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.petservices.dao.MascotaDAO;
import com.petservices.model.Mascota;
import com.petservices.service.MascotaService;

@SpringBootTest
class MascotaServiceTest {
	
	@MockBean
	private MascotaDAO mascotaDAO;
	@Autowired
	private MascotaService mascotaService;
	
	@Test
	void guardarTest () {
		
		//Arrange
		Mascota mascota = new Mascota ();
		Mockito.doAnswer(i -> {
			return null;
		}).when(mascotaDAO).save(mascota);
		
		//Act
		mascotaService.guardar(mascota);
		//Assert
		Mockito.verify(mascotaDAO, Mockito.times(1)).save(mascota);
	}
	
	@Test
	void borrarTest () {
		
		//Arrange
		Mascota mascota = new Mascota ();
		Mockito.doAnswer(i -> {
			return null;
		}).when(mascotaDAO).delete(mascota);
		//Act
		mascotaService.borrar(mascota);
		//Assert
		Mockito.verify(mascotaDAO, Mockito.times(1)).delete(mascota);
	}
	
	@Test
	void obtenerMascotasTest () {
		
		//Arrange
		List<Mascota> mascotas;
		Mockito.doAnswer(i -> {
			return new ArrayList<>();
		}).when(mascotaDAO).findAll();
		//Act
		mascotas = mascotaService.obtenerMascotas();
		//Assert
		Assertions.assertNotNull(mascotas);
	}
	
	@Test
	void obtenerMascotaConIdTest () {
		
		//Arrange
		Mascota mascota = new Mascota();
		int id = 1;
		Mockito.doAnswer(i -> {
			return Optional.ofNullable(mascota);
		}).when(mascotaDAO).findById(id);
		//Act
		Mascota mascotaObtenida;
		mascotaObtenida = mascotaService.obtenerMascotaConId(id);
		//Assert
		Assertions.assertNotNull(mascotaObtenida);
		
	}
	
	@Test
	void obtenerMascotaConIdNullTest () {
		
		//Arrange
		Mascota mascota = null;
		int id = 1;
		Mockito.doAnswer(i -> {
			return Optional.ofNullable(mascota);
		}).when(mascotaDAO).findById(id);
		//Act
		Mascota mascotaObtenida;
		mascotaObtenida = mascotaService.obtenerMascotaConId(id);
		//Assert
		Assertions.assertNotNull(mascotaObtenida);
		
	}
}
