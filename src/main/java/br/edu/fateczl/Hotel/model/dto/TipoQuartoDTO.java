package br.edu.fateczl.Hotel.model.dto;

import java.io.Serializable;

import br.edu.fateczl.Hotel.model.dto.interfaces.IDTO;
import br.edu.fateczl.Hotel.model.entity.TipoQuarto;

public class TipoQuartoDTO implements IDTO<TipoQuarto>, Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private double valorDiaria;
	private String tipo;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public TipoQuarto toEntity() {
		TipoQuarto tq = new TipoQuarto();
		tq.setId(this.id);
		tq.setTipo(this.tipo);
		tq.setValorDiaria(this.valorDiaria);
		return tq;
	}
}
