package br.edu.fateczl.Hotel.model.dto;

import java.time.LocalDateTime;
import br.edu.fateczl.Hotel.model.dto.interfaces.IDTO;
import br.edu.fateczl.Hotel.model.entity.PessoaID;
import br.edu.fateczl.Hotel.model.entity.QuartoID;
import br.edu.fateczl.Hotel.model.entity.Reserva;
import br.edu.fateczl.Hotel.model.entity.VagaId;

public class ReservaDTO implements IDTO<Reserva> {
	private String dataInicio;
	private String dataFim;
	private PessoaID documento;
	private PessoaID tipoDocumento;
	private QuartoID quartoID;
	private VagaId vagaEstacionamento;
	private VagaId numVaga;

	public VagaId getNumVaga() {
		return numVaga;
	}

	public void setNumVaga(VagaId numVaga) {
		this.numVaga = numVaga;
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

	public PessoaID getDocumento() {
		return documento;
	}

	public void setDocumento(PessoaID documento) {
		this.documento = documento;
	}

	public PessoaID getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(PessoaID tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public QuartoID getQuartoID() {
		return quartoID;
	}

	public void setQuartoID(QuartoID quartoID) {
		this.quartoID = quartoID;
	}

	public VagaId getVagaEstacionamento() {
		return vagaEstacionamento;
	}

	public void setVagaEstacionamento(VagaId vagaEstacionamento) {
		this.vagaEstacionamento = vagaEstacionamento;
	}

	@Override
	public Reserva toEntity() {
		Reserva r = new Reserva();
		r.setDocumento(this.documento);
		r.setNumVaga(this.vagaEstacionamento);
		r.setQuartoID(this.quartoID);
		r.setTipoDocumento(this.tipoDocumento);
		r.setVagaEstacionamento(this.vagaEstacionamento);
		r.setNumVaga(this.vagaEstacionamento);
		r.converterDataFim(this.dataFim);
		r.converterDataInicio(this.dataInicio);
		r.setDataFim(this.dataFim);
		return r;
	}

}