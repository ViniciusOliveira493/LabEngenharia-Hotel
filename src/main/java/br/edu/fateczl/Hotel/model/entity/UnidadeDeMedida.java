package br.edu.fateczl.Hotel.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.fateczl.Hotel.model.dto.UnidadeDeMedidaDTO;

@Entity
@Table(name = "tbUnidadeDeMedida")
public class UnidadeDeMedida {
	@Id
	@Column(name = "nome",length = 20,nullable = false)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	} 
	
	public UnidadeDeMedidaDTO toDTO() {
		UnidadeDeMedidaDTO dto = new UnidadeDeMedidaDTO();
		dto.setNome(this.nome);
		return dto;
	}
}
