package br.edu.fateczl.Hotel.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.fateczl.Hotel.model.dto.TipoVagaDTO;

@Entity
@Table(name = "tbTipoVaga")
public class TipoVaga {
	@Id
	@Column(name = "tipo", length = 15, nullable = false)
	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	
	
	public TipoVagaDTO toDTO() {
		TipoVagaDTO dto = new TipoVagaDTO();
		dto.setTipo(this.tipo);
		return dto;
	}
}
