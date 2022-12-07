package br.edu.fateczl.Hotel.model.dto;

import br.edu.fateczl.Hotel.model.dto.interfaces.IDTO;
import br.edu.fateczl.Hotel.model.entity.ProdutoServico;
import br.edu.fateczl.Hotel.model.entity.ProdutoServicoID;

public class ProdutoServicoDTO implements IDTO<ProdutoServico> {

	private Integer produtoId;
	private Integer servicoId;
	private Integer qtd;

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public Integer getServicoId() {
		return servicoId;
	}

	public void setServicoId(Integer servicoId) {
		this.servicoId = servicoId;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	@Override
	public ProdutoServico toEntity() {
		ProdutoServico ps = new ProdutoServico();
		ps.setQtd(this.qtd);
		ProdutoServicoID psid = new ProdutoServicoID();
		psid.setCodigoProduto(this.produtoId);
		psid.setIdServico(this.servicoId);
		ps.setId(psid);
		return ps;
	}

}
