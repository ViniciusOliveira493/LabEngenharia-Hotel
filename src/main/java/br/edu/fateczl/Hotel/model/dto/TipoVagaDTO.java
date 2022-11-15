package br.edu.fateczl.Hotel.model.dto;

import br.edu.fateczl.Hotel.model.entity.TipoVaga;

public class TipoVagaDTO {
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

	public TipoVaga toEntity() {
		TipoVaga t = new TipoVaga();
		t.setId(this.id);
		t.setTipo(this.tipo);
		return t;
	}	
}
