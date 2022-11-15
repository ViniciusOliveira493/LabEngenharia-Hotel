package br.edu.fateczl.Hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fateczl.Hotel.model.entity.Vaga;
import br.edu.fateczl.Hotel.model.entity.Vaga.VagaId;

public interface VagaRepository extends JpaRepository<Vaga, VagaId>{

}
