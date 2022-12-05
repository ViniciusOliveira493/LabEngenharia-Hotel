package br.edu.fateczl.Hotel.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.fateczl.Hotel.model.dto.TipoQuartoDTO;
import br.edu.fateczl.Hotel.model.entity.interfaces.IEntity;

@Entity
@Table(name = "tbTipoQuarto")
public class TipoQuarto implements IEntity<TipoQuartoDTO>, Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	@Column(name = "tipo", nullable = false)
	private String tipo;
	@Column(name = "valordiaria", nullable = false)
	private double valorDiaria;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoQuartoDTO toDTO() {
		TipoQuartoDTO dto = new TipoQuartoDTO();
		dto.setId(this.id);
		dto.setTipo(this.tipo);
		dto.setValorDiaria(this.valorDiaria);
		return dto;
	}
}
