package br.edu.fateczl.Hotel.model.dto;

import br.edu.fateczl.Hotel.model.dto.interfaces.IDTO;
import br.edu.fateczl.Hotel.model.entity.Pessoa;
import br.edu.fateczl.Hotel.model.entity.Quarto;
import br.edu.fateczl.Hotel.model.entity.Reserva;
import br.edu.fateczl.Hotel.model.entity.Vaga;

public class ReservaDTO implements IDTO<Reserva> {
	private Long id;
	private String dataInicio;
	private String dataFim;
	private PessoaDTO documento;
	private QuartoDTO quarto;
	private VagaDTO vaga;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VagaDTO getVaga() {
		return vaga;
	}

	public void setVaga(Vaga numVaga) {
		this.vaga = numVaga.toDTO();
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

	public PessoaDTO getDocumento() {
		return documento;
	}

	public void setDocumento(Pessoa documento) {
		this.documento = documento.toDTO();
	}

	public QuartoDTO getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto.toDTO();
	}

	
	@Override
	public String toString() {
		return "ReservaDTO [dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", documento=" + documento
				+ ", quarto=" + quarto + ", vaga=" + vaga + "]";
	}

	@Override
	public Reserva toEntity() {
		Reserva r = new Reserva();
		r.setId(this.id);
		r.setCliente(this.documento.toEntity());
		r.setVaga(this.vaga.toEntity());
		r.setQuarto(this.quarto.toEntity());
		r.converterDataFim(this.dataFim);
		r.converterDataInicio(this.dataInicio);
		r.setDataFim(this.dataFim);
		return r;
	}

}