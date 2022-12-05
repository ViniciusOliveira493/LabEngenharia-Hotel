package br.edu.fateczl.Hotel.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.fateczl.Hotel.model.dto.ReservaServicoDTO;
import br.edu.fateczl.Hotel.model.entity.interfaces.IEntity;

@Entity
@Table(name = "tbProdutoServico")
public class ReservaServico implements IEntity<ReservaServicoDTO> {

	@EmbeddedId
	private ReservaServicoID id;

	public ReservaServicoID getId() {
		return id;
	}

	public void setId(ReservaServicoID id) {
		this.id = id;
	}

	@Override
	public ReservaServicoDTO toDTO() {
		ReservaServicoDTO dto = new ReservaServicoDTO();
		dto.setQuartoID(this.id.getQuartoID());
		dto.setDataInicio(this.id.getDataInicio());
		dto.setPessoaDocumento(this.id.getPessoaDocumento());;
		dto.setTipoDocumento(this.id.getTipoDocumento());
		dto.setsID(this.id.getsID());
		return dto;
	}

}
