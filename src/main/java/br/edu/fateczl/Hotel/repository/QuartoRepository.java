package br.edu.fateczl.Hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fateczl.Hotel.model.entity.Quarto;
import br.edu.fateczl.Hotel.model.entity.QuartoID;


public interface QuartoRepository extends JpaRepository<Quarto, QuartoID>{

}
