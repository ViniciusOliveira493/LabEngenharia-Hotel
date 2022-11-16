package br.edu.fateczl.Hotel.model.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.fateczl.Hotel.model.dto.FuncionarioDTO;
import br.edu.fateczl.Hotel.model.dto.PessoaDTO;
import br.edu.fateczl.Hotel.model.entity.interfaces.IEntity;

@Entity
@Table(name = "tbPessoa")
public class Pessoa implements IEntity<PessoaDTO>{
	@EmbeddedId
	private PessoaID id;
	
	@Embeddable
	public class PessoaID implements Serializable{
		private static final long serialVersionUID = 1L;

		@Column(name = "documento",length = 20,nullable = false)
		private String documento;
		
		@ManyToOne(targetEntity = TipoDocumento.class, fetch = FetchType.LAZY)
		@JoinColumn(name = "tipoDocumento", nullable = false)
		private TipoDocumento tipoDocumento;

		public String getDocumento() {
			return documento;
		}

		public void setDocumento(String documento) {
			this.documento = documento;
		}

		public TipoDocumento getTipoDocumento() {
			return tipoDocumento;
		}

		public void setTipoDocumento(TipoDocumento tipoDocumento) {
			this.tipoDocumento = tipoDocumento;
		}
	}
	@Column(name = "nome",length = 80,nullable = false)
	private String nome;
	@Column(name = "email",length = 255,nullable = false)
	private String email;
	@Column(name = "senha",length = 32,nullable = false)//Senha usará md5 
	private String senha;
	@Column(name = "telefone",length = 20,nullable = false)
	private String telefone;
	
	public PessoaID getId() {
		return id;
	}
	public void setId(PessoaID id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = MD5(senha);
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public static String MD5(String txt) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1,md.digest(txt.getBytes()));
			return hash.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "ERROR_90_43_21";
	}
	
	@Override
	public PessoaDTO toDTO() {
		PessoaDTO dto = new PessoaDTO();
		dto.setDocumento(id.getDocumento());
		dto.setTipoDocumento(id.getTipoDocumento());
		dto.setEmail(this.getEmail());
		dto.setNome(this.getNome());
		dto.setTelefone(this.getTelefone());
		return dto;
	}
}
