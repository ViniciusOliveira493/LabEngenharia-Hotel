package br.edu.fateczl.Hotel.model.dto;

import java.io.Serializable;

import br.edu.fateczl.Hotel.model.dto.interfaces.IDTO;
import br.edu.fateczl.Hotel.model.entity.TipoDocumento;

public class TipoDocumentoDTO implements IDTO<TipoDocumento>,Serializable{
	private static final long serialVersionUID = 1L;
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

	
	@Override
	public String toString() {
		return "TipoDocumentoDTO [id=" + id + ", tipo=" + tipo + "]";
	}

	public TipoDocumento toEntity() {
		TipoDocumento ent = new TipoDocumento();
		ent.setTipo(this.tipo);
		ent.setId(this.id);
		return ent;
	}
}
