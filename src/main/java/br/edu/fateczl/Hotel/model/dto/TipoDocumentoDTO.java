package br.edu.fateczl.Hotel.model.dto;

import br.edu.fateczl.Hotel.model.entity.TipoDocumento;

public class TipoDocumentoDTO {
	private int id;
	private String tipo;
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoDocumento toEntity() {
		TipoDocumento ent = new TipoDocumento();
		ent.setTipo(this.tipo);
		ent.setId(this.id);
		return ent;
	}
}
