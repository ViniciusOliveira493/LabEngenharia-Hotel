package br.edu.fateczl.Hotel.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class QuartoID implements Serializable {
	private static final long serialVersionUID = 1L;

	public QuartoID() {

	}

	public QuartoID(int ID) {
		this.ID = ID;
	}

	@Column(name = "id", nullable = false)
	private int ID;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

}
