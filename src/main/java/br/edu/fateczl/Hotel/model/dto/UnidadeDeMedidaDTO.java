package br.edu.fateczl.Hotel.model.dto;

import br.edu.fateczl.Hotel.model.dto.interfaces.IDTO;
import br.edu.fateczl.Hotel.model.entity.UnidadeDeMedida;

public class UnidadeDeMedidaDTO implements IDTO<UnidadeDeMedida>{
	private int id;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UnidadeDeMedida toEntity() {
		UnidadeDeMedida un = new UnidadeDeMedida();
		un.setId(this.id);
		un.setNome(this.nome);
		return un;
	}
	
	
}
