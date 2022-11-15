package br.edu.fateczl.Hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fateczl.Hotel.model.entity.Funcionario;
import br.edu.fateczl.Hotel.model.entity.Pessoa.PessoaID;

public interface FuncionarioRepository extends JpaRepository<Funcionario, PessoaID>{

}
