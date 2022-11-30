package br.edu.fateczl.Hotel.model.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.fateczl.Hotel.model.dto.ProdutoServicoDTO;
import br.edu.fateczl.Hotel.model.entity.interfaces.IEntity;

@Entity
@Table(name = "tbProdutoServico")
public class ProdutoServico implements IEntity<ProdutoServicoDTO> {

	@EmbeddedId
	private ProdutoServicoID id;

	@Column(name = "qtd", nullable = false)
	private Integer qtd;

	public ProdutoServicoID getId() {
		return id;
	}

	public void setId(ProdutoServicoID id) {
		this.id = id;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	@Override
	public ProdutoServicoDTO toDTO() {
		ProdutoServicoDTO dto = new ProdutoServicoDTO();
		dto.setPid(this.id.getPCodigo());
		dto.setSid(this.id.getSCodigo());
		return dto;
	}

}
