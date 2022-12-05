package br.edu.fateczl.Hotel.model.dto;

import br.edu.fateczl.Hotel.model.dto.interfaces.IDTO;
import br.edu.fateczl.Hotel.model.entity.Pessoa;
import br.edu.fateczl.Hotel.model.entity.Quarto;
import br.edu.fateczl.Hotel.model.entity.QuartoID;
import br.edu.fateczl.Hotel.model.entity.Reserva;
import br.edu.fateczl.Hotel.model.entity.Vaga;
import br.edu.fateczl.Hotel.model.entity.VagaId;

public class ReservaDTO implements IDTO<Reserva> {
	private String dataInicio;
	private String dataFim;
	private Pessoa documento;
	private Quarto quarto;
	private Vaga vaga;

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga numVaga) {
		this.vaga = numVaga;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public Pessoa getDocumento() {
		return documento;
	}

	public void setDocumento(Pessoa documento) {
		this.documento = documento;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	@Override
	public Reserva toEntity() {
		Reserva r = new Reserva();
		r.setCliente(this.documento);
		r.setVaga(this.vaga);
		r.setQuarto(this.quarto);
		r.converterDataFim(this.dataFim);
		r.converterDataInicio(this.dataInicio);
		r.setDataFim(this.dataFim);
		return r;
	}

}