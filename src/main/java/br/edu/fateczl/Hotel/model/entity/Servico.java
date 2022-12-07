package br.edu.fateczl.Hotel.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.edu.fateczl.Hotel.model.dto.ServicoDTO;
import br.edu.fateczl.Hotel.model.entity.interfaces.IEntity;


@Entity
@Table(name = "tbServico")

public class Servico implements IEntity<ServicoDTO> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 50, nullable = false)
	private Integer id;

	
	@Column(name = "nome", length = 50, nullable = true)
	private String nome;

	@Column(name = "valor", nullable = false)
	private Double valor;	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public ServicoDTO toDTO() {
		ServicoDTO dto = new ServicoDTO();
		dto.setId(this.id);
		dto.setNome(this.nome);
		dto.setValor(this.valor);
		return dto;
	}



}
