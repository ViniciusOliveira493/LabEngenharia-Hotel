package br.edu.fateczl.Hotel.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import br.edu.fateczl.Hotel.model.dto.ServicoDTO;
import br.edu.fateczl.Hotel.model.entity.interfaces.IEntity;


@Entity
@Table(name = "tbServico")

public class Servico implements IEntity<ServicoDTO> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo", length = 50, nullable = false)
	private Integer codigo;

	
	@Column(name = "nome", length = 50, nullable = true)
	private String nome;

	@Column(name = "valor", nullable = false)
	private Double valor;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
		dto.setCodigo(this.codigo);
		dto.setNome(this.nome);
		dto.setValor(this.valor);
		return dto;
	}



}
