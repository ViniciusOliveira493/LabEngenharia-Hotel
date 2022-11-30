package br.edu.fateczl.Hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fateczl.Hotel.model.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
