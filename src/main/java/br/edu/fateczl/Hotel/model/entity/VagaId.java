package br.edu.fateczl.Hotel.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VagaId implements Serializable {
	private static final long serialVersionUID = 1L;

	public VagaId() {
		// TODO Auto-generated constructor stub
	}

	public VagaId(String estacionamento, int numVaga) {
		this.estacionamento = estacionamento;
		this.numVaga = numVaga;
	}

	@Column(name = "estacionamento", length = 15, nullable = false)
	private String estacionamento;

	@Column(name = "numVaga", nullable = false)
	private int numVaga;

	public String getEstacionamento() {
		return estacionamento;
	}

	public void setEstacionamento(String estacionamento) {
		this.estacionamento = estacionamento;
	}

	public int getNumVaga() {
		return numVaga;
	}

	public void setNumVaga(int numVaga) {
		this.numVaga = numVaga;
	}

	@Override
	public String toString() {
		return "VagaId [estacionamento=" + estacionamento + ", numVaga=" + numVaga + "]";
	}
	
	
}
