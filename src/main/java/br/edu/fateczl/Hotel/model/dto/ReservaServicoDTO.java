package br.edu.fateczl.Hotel.model.dto;

import br.edu.fateczl.Hotel.model.dto.interfaces.IDTO;
import br.edu.fateczl.Hotel.model.entity.Reserva;
import br.edu.fateczl.Hotel.model.entity.ReservaServico;
import br.edu.fateczl.Hotel.model.entity.ReservaServicoID;
import br.edu.fateczl.Hotel.model.entity.Servico;

public class ReservaServicoDTO implements IDTO<ReservaServico> {

	private Servico sID;
	private Reserva tipoDocumento;
	private Reserva dataInicio;
	private Reserva pessoaDocumento;
	private Reserva quartoID;

	public Servico getsID() {
		return sID;
	}

	public void setsID(Servico sID) {
		this.sID = sID;
	}

	public Reserva getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Reserva tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Reserva getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Reserva dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Reserva getPessoaDocumento() {
		return pessoaDocumento;
	}

	public void setPessoaDocumento(Reserva pessoaDocumento) {
		this.pessoaDocumento = pessoaDocumento;
	}

	public Reserva getQuartoID() {
		return quartoID;
	}

	public void setQuartoID(Reserva quartoID) {
		this.quartoID = quartoID;
	}

	@Override
	public ReservaServico toEntity() {
		ReservaServico rs = new ReservaServico();
		ReservaServicoID rsID = new ReservaServicoID();
		rsID.setPessoaDocumento(this.pessoaDocumento);
		rsID.setDataInicio(this.dataInicio);
		rsID.setQuartoID(this.quartoID);
		rsID.setTipoDocumento(this.tipoDocumento);
		rsID.setsID(this.sID);
		rs.setId(rsID);
		return rs;
	}
}
