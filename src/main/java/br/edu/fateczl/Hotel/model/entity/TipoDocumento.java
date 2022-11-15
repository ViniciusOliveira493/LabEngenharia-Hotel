package br.edu.fateczl.Hotel.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.fateczl.Hotel.model.dto.TipoDocumentoDTO;

@Entity
@Table(name = "tbTipoDocumento")
public class TipoDocumento {
	@Id
	@Column(name = "nomeTipo",length = 50, nullable = false)
	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public TipoDocumentoDTO toDTO() {
		TipoDocumentoDTO dto = new TipoDocumentoDTO();
		dto.setTipo(this.tipo);
		return dto;
	}
}
