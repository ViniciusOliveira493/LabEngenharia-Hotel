package br.edu.fateczl.Hotel.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.fateczl.Hotel.model.dto.FuncionarioDTO;
import br.edu.fateczl.Hotel.model.dto.PessoaDTO;
import br.edu.fateczl.Hotel.model.entity.interfaces.IEntity;

@Entity
@Table(name = "tbFuncionario")
public class Funcionario extends Pessoa{
	//Funcionario admin = 0 | Gerente = 1 | Atendente = 2
	@Column(name = "funcao",nullable = false) 
	private int funcao;

	public int getFuncao() {
		return funcao;
	}

	public void setFuncao(int funcao) {
		this.funcao = funcao;
	}
	
	public FuncionarioDTO toDTOFuncionario() {
		PessoaDTO pDto = this.toDTO(); 
		FuncionarioDTO dto = new FuncionarioDTO();
		dto.setDocumento(pDto.getDocumento());
		dto.setEmail(pDto.getEmail());
		dto.setFuncao(this.getFuncao());
		dto.setNome(pDto.getNome());
		dto.setTelefone(pDto.getTelefone());
		dto.setTipoDocumento(pDto.getTipoDocumento());
		return dto;
	}
}
