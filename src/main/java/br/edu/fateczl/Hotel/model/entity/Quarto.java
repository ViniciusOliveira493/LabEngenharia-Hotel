package br.edu.fateczl.Hotel.model.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.edu.fateczl.Hotel.model.dto.QuartoDTO;
import br.edu.fateczl.Hotel.model.entity.interfaces.IEntity;

@Entity
@Table(name = "tbQuarto")
public class Quarto implements IEntity<QuartoDTO> {
	@EmbeddedId
	private QuartoID id;

	@ManyToOne(targetEntity = TipoQuarto.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo", nullable = false)
	private TipoQuarto tipo;

	@Column(name = "andar", nullable = false)
	private Integer andar;

	@Column(name = "numero", nullable = false)
	private Integer numero;

	@Column(name = "predio", nullable = false)
	private String predio;

	public QuartoID getId() {
		return id;
	}

	public void setId(QuartoID id) {
		this.id = id;
	}

	public TipoQuarto getTipo() {
		return tipo;
	}

	public void setTipo(TipoQuarto tipo) {
		this.tipo = tipo;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(Integer andar) {
		this.andar = andar;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getPredio() {
		return predio;
	}

	public void setPredio(String predio) {
		this.predio = predio;
	}

	public QuartoDTO toDTO() {
		QuartoDTO dto = new QuartoDTO();
		dto.setAndar(this.andar);
		dto.setNumero(this.numero);
		dto.setPredio(this.predio);
		dto.setTipo(this.tipo.toDTO());
		dto.setId(this.id.getID());
		return dto;
	}
}