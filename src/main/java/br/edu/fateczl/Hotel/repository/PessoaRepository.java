package br.edu.fateczl.Hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fateczl.Hotel.model.entity.Pessoa;
import br.edu.fateczl.Hotel.model.entity.PessoaID;

public interface PessoaRepository extends JpaRepository<Pessoa, PessoaID>{
	Pessoa findByIdDocumento(String documento);
}
