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
		this.codigo = codigo;
		this.id = id;
	}
	
	
	
	@ManyToOne(targetEntity = Produto.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo", nullable = false)
	private Integer codigo;
	
	
	@ManyToOne(targetEntity = Servico.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "id", nullable = false)
	private Integer id;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

}
