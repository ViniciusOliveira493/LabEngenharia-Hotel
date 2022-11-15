package br.edu.fateczl.Hotel.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
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
	@Embeddable
	public class VagaId implements Serializable{
		private static final long serialVersionUID = 1L;

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
	}
	
	@EmbeddedId
	private VagaId id;
	
	@Column(name = "descricao", length = 255, nullable = true)
	private String descricao;
	@ManyToOne(targetEntity = TipoVaga.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo", nullable = false)
	private TipoVaga tipo;
	@Column(name = "valorDiaria", nullable = false)
	private double valorDiaria;

	public VagaId getId() {
		return id;
	}
	public void setId(VagaId id) {
		this.id = id;
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
		dto.setEstacionamento(this.id.getEstacionamento());
		dto.setNumVaga(this.id.getNumVaga());
		dto.setTipo(this.tipo);
		dto.setValorDiaria(this.valorDiaria);
		return dto;
	}
}
