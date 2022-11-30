package br.edu.fateczl.Hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fateczl.Hotel.model.entity.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer>{
	
}