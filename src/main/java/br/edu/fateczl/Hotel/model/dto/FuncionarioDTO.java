package br.edu.fateczl.Hotel.model.dto;

import br.edu.fateczl.Hotel.model.entity.Funcionario;

public class FuncionarioDTO extends PessoaDTO{
	private int funcao;

	public int getFuncao() {
		return funcao;
	}

	public void setFuncao(int funcao) {
		this.funcao = funcao;
	}

	
	public Funcionario toEntityFuncionario() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
