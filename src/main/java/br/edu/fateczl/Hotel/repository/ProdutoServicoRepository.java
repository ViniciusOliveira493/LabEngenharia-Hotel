package br.edu.fateczl.Hotel.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fateczl.Hotel.model.entity.ProdutoServico;
import br.edu.fateczl.Hotel.model.entity.ProdutoServicoID;

public interface ProdutoServicoRepository extends JpaRepository<ProdutoServico, ProdutoServicoID>{

}
