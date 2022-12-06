package br.edu.fateczl.Hotel.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.fateczl.Hotel.model.dto.TipoDocumentoDTO;
import br.edu.fateczl.Hotel.model.entity.interfaces.IEntity;

@Entity
@Table(name = "tbTipoDocumento")
public class TipoDocumento implements IEntity<TipoDocumentoDTO>,Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	@Column(name = "nomeTipo",length = 50, nullable = false)
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
		return "TipoDocumento [id=" + id + ", tipo=" + tipo + "]";
	}

	public TipoDocumentoDTO toDTO() {
		TipoDocumentoDTO dto = new TipoDocumentoDTO();
		dto.setTipo(this.tipo);
		dto.setId(this.id);
		return dto;
	}
}
