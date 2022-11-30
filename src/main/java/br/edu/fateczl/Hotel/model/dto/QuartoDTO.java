package br.edu.fateczl.Hotel.model.dto;

import br.edu.fateczl.Hotel.model.dto.interfaces.IDTO;
import br.edu.fateczl.Hotel.model.entity.Quarto;
import br.edu.fateczl.Hotel.model.entity.QuartoID;
import br.edu.fateczl.Hotel.model.entity.TipoVaga;
import br.edu.fateczl.Hotel.model.entity.Vaga;
import br.edu.fateczl.Hotel.model.entity.VagaId;

public class QuartoDTO implements IDTO<Quarto> {
	private int id;
	private TipoQuartoDTO tipo;
	private String predio;
	private int andar;
	private int numero;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoQuartoDTO getTipo() {
		return tipo;
	}

	public void setTipo(TipoQuartoDTO tipo) {
		this.tipo = tipo;
	}

	public String getPredio() {
		return predio;
	}

	public void setPredio(String predio) {
		this.predio = predio;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public Quarto toEntity() {
		Quarto q = new Quarto();
		q.setAndar(this.andar);
		QuartoID qID = new QuartoID();
		qID.setID(this.id);
		q.setId(qID);
		q.setTipo(this.tipo.toEntity());
		return q;
	}
}