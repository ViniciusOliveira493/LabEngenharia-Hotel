package br.edu.fateczl.Hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fateczl.Hotel.model.entity.ReservaServico;
import br.edu.fateczl.Hotel.model.entity.ReservaServicoID;

public interface ReservaServicoRepository extends JpaRepository<ReservaServico, ReservaServicoID> {

}
