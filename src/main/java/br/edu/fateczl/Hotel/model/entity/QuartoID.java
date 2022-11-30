package br.edu.fateczl.Hotel.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class QuartoID implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name = "id",length = 10,nullable = false)
	private int id;
	
	@ManyToOne(targetEntity = TipoQuarto.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "tipoQuarto", nullable = false)
	private TipoQuarto tipoQuarto;

	public int getQuarto() {
		return id;
	}

	public void setQuarto(int id) {
		this.id = id;
	}

	public TipoQuarto getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(TipoQuarto tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}
}
