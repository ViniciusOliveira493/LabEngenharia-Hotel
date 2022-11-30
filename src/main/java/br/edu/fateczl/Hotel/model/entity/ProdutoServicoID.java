package br.edu.fateczl.Hotel.model.entity;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ProdutoServicoID implements Serializable {
	private static final long serialVersionUID = 1L;

	public ProdutoServicoID() {
		// TODO Auto-generated constructor stub
	}
	
	public ProdutoServicoID(Integer PCodigo, Integer SCodigo) {
		this.PCodigo = PCodigo;
		this.SCodigo = SCodigo;
	}
	
	
	
	@ManyToOne(targetEntity = Produto.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "id", nullable = false)
	private Integer PCodigo;
	
	
	@ManyToOne(targetEntity = Servico.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo", nullable = false)
	private Integer SCodigo;

	public Integer getPCodigo() {
		return PCodigo;
	}

	public void setPCodigo(Integer pCodigo) {
		PCodigo = pCodigo;
	}

	public Integer getSCodigo() {
		return SCodigo;
	}

	public void setSCodigo(Integer sCodigo) {
		SCodigo = sCodigo;
	}

}
