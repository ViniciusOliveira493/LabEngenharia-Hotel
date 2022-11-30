package br.edu.fateczl.Hotel.model.dto;

import br.edu.fateczl.Hotel.model.dto.interfaces.IDTO;
import br.edu.fateczl.Hotel.model.entity.ProdutoServico;
import br.edu.fateczl.Hotel.model.entity.ProdutoServicoID;

public class ProdutoServicoDTO implements IDTO<ProdutoServico> {

	private Integer pid;
	private Integer sid;
	private Integer qtd;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
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
		psid.setPCodigo(this.pid);
		psid.setSCodigo(this.sid);
		ps.setId(psid);
		return ps;
	}

}
