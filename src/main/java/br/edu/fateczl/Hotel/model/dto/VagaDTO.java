package br.edu.fateczl.Hotel.model.dto;

import br.edu.fateczl.Hotel.model.entity.TipoVaga;

public class VagaDTO {
	private String estacionamento;
	private int numVaga;
	private String descricao;
	private TipoVagaDTO tipo;
	private double valorDiaria;
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public TipoVagaDTO getTipo() {
		return tipo;
	}
	public void setTipo(TipoVaga tipo) {
		this.tipo = tipo.toDTO();
	}
	public void setTipo(TipoVagaDTO tipo) {
		this.tipo = tipo;
	}
	public double getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
}
