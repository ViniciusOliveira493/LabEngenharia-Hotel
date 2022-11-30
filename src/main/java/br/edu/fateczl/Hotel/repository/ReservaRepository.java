package br.edu.fateczl.Hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fateczl.Hotel.model.entity.Reserva;
import br.edu.fateczl.Hotel.model.entity.ReservaID;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, ReservaID>{
	
}