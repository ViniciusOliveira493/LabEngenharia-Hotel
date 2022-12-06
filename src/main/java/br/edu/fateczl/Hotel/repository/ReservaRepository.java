package br.edu.fateczl.Hotel.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.fateczl.Hotel.model.entity.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, BigInteger>{
	@Query(
			value = "SELECT "
					+ "	* "
					+ " FROM tbReserva"
					+ " WHERE tipoDocumento = ?1 AND "
					+ " documento = ?2 AND"
					+ " datainicio = ?3"
			,nativeQuery = true
	)
	public List<Reserva> buscarData(int tdoc,String doc,String data);
	
	@Query(
			value = "SELECT "
					+ "	* "
					+ " FROM tbReserva"
					+ " WHERE tipoDocumento = ?1 AND "
					+ " documento = ?2 AND"
					+ " datainicio LIKE ?3%"
			,nativeQuery = true
	)
	public List<Reserva> buscarReservas(int tdoc,String doc,String data);
}