package br.edu.fateczl.Hotel.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fateczl.Hotel.model.entity.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, BigInteger>{
	
}