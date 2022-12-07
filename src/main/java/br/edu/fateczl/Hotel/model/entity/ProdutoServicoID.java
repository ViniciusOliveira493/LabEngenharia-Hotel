package br.edu.fateczl.Hotel.model.entity;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ProdutoServicoID implements Serializable {
	private static final long serialVersionUID = 1L;	
	
	public ProdutoServicoID() {
		// TODO Auto-generated constructor stub
	}
	
	public ProdutoServicoID(Integer codigo, Integer id) {
		this.codigoProduto = codigo;
		this.idServico = id;
	}
	
	@ManyToOne(targetEntity = Produto.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "codigoProduto", nullable = false)
	private Integer codigoProduto;
	
	@ManyToOne(targetEntity = Servico.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "idServico", nullable = false)
	private Integer idServico;

	public Integer getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}
}
