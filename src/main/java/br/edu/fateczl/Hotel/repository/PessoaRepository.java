package br.edu.fateczl.Hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fateczl.Hotel.model.entity.Pessoa;
import br.edu.fateczl.Hotel.model.entity.PessoaID;

public interface PessoaRepository extends JpaRepository<Pessoa, PessoaID>{
	Pessoa findByIdDocumento(String documento);
	List<Pessoa> fn_findAllFuncionarios();
	Pessoa fn_login(String email,String senha);
}
