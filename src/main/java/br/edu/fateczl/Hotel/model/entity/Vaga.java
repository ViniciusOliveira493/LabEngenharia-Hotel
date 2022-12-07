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

import br.edu.fateczl.Hotel.model.dto.TipoVagaDTO;
import br.edu.fateczl.Hotel.model.dto.VagaDTO;
import br.edu.fateczl.Hotel.model.entity.interfaces.IEntity;

@Entity
@Table(name = "tbVaga")
public class Vaga implements IEntity<VagaDTO>{		
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
		if(this.id != null) {
			dto.setDescricao(this.descricao);		
			dto.setEstacionamento(this.id.getEstacionamento());		
			dto.setNumVaga(this.id.getNumVaga());
			dto.setTipo(this.tipo.toDTO());				
			dto.setValorDiaria(this.valorDiaria);
		}
		return dto;
	}
}
