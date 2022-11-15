package br.edu.fateczl.Hotel.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.fateczl.Hotel.model.dto.VagaDTO;

@Entity
@Table(name = "tbVaga")
public class Vaga {
	@Id
	@Column(name = "estacionamento", length = 15, nullable = false)
	private String estacionamento;
	@Id
	@Column(name = "numVaga", nullable = false)
	private int numVaga;
	@Column(name = "descricao", length = 255, nullable = true)
	private String descricao;
	@ManyToOne(targetEntity = TipoVaga.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo", nullable = false)
	private TipoVaga tipo;
	@Column(name = "valorDiaria", nullable = false)
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
	public TipoVaga getTipo() {
		return tipo;
	}
	public void setTipo(TipoVaga tipo) {
		this.tipo = tipo;
	}
	public double getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
	public VagaDTO toDTO() {
		VagaDTO dto = new VagaDTO();
		dto.setDescricao(this.descricao);
		dto.setEstacionamento(this.estacionamento);
		dto.setNumVaga(this.numVaga);
		dto.setTipo(this.tipo);
		dto.setValorDiaria(this.valorDiaria);
		return dto;
	}
}
