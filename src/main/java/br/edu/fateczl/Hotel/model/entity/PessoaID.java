package br.edu.fateczl.Hotel.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class PessoaID implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name = "documento",length = 20,nullable = false)
	private String documento;
	
	@ManyToOne(targetEntity = TipoDocumento.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "tipoDocumento", nullable = false)
	private TipoDocumento tipoDocumento;

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
}
