package br.edu.fateczl.Hotel.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.fateczl.Hotel.model.dto.UnidadeDeMedidaDTO;
import br.edu.fateczl.Hotel.model.entity.interfaces.IEntity;

@Entity
@Table(name = "tbUnidadeDeMedida")
public class UnidadeDeMedida implements IEntity<UnidadeDeMedidaDTO>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false)
	private Integer id; 
	@Column(name = "nome",length = 20,nullable = false)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	} 
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UnidadeDeMedidaDTO toDTO() {
		UnidadeDeMedidaDTO dto = new UnidadeDeMedidaDTO();
		dto.setNome(this.nome);
		dto.setId(this.id);
		return dto;
	}
}
