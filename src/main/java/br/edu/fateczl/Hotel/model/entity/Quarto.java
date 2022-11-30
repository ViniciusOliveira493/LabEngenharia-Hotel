package br.edu.fateczl.Hotel.model.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.edu.fateczl.Hotel.model.dto.QuartoDTO;
import br.edu.fateczl.Hotel.model.entity.interfaces.IEntity;

@Entity
@Table(name = "tbQuarto")
public class Quarto implements IEntity<QuartoDTO> {
	@EmbeddedId
	private QuartoID id;

	@ManyToOne(targetEntity = TipoQuarto.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo", nullable = false)
	private TipoQuarto tipo;
	@Column(name = "valorDiaria", nullable = false)
	private double valorDiaria;
	private int andar;
	private int numero;
	private String predio;

	public QuartoID getId() {
		return id;
	}

	public void setId(QuartoID id) {
		this.id = id;
	}

	public TipoQuarto getTipo() {
		return tipo;
	}

	public void setTipo(TipoQuarto tipo) {
		this.tipo = tipo;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPredio() {
		return predio;
	}

	public void setPredio(String predio) {
		this.predio = predio;
	}

	public QuartoDTO toDTO() {
		QuartoDTO dto = new QuartoDTO();
		dto.setAndar(this.andar);
		dto.setPredio(this.predio);
		dto.setId(this.id);
		dto.setNumero(this.numero);
		dto.setTipo(this.tipo.toDTO());
		return dto;
	}
}