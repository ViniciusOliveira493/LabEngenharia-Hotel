package br.edu.fateczl.Hotel.repository.pscr;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.Hotel.model.dto.ProdutoServicoDTO;
import br.edu.fateczl.Hotel.model.entity.ProdutoServico;
import br.edu.fateczl.Hotel.model.entity.ProdutoServicoID;
import br.edu.fateczl.Hotel.repository.PessoaCustomRep.Conexao;

public class ProdutoServicoCustomRepository {
	Conexao cn = new Conexao();
	
	public List<ProdutoServico> find(BigInteger s) {
		Connection conn = cn.getConexao();
		try {
			String query = "";
			query = "SELECT * FROM tbProdutoServico"
					+ " WHERE idServico = ?";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, s+"");
			ResultSet rs = pstm.executeQuery();
			List<ProdutoServico> lista = new ArrayList<>();
			while(rs.next()) {
				ProdutoServico ps = new ProdutoServico();
				ps.setQtd(rs.getInt("qtd"));
				ProdutoServicoID psid = new ProdutoServicoID();
				psid.setCodigoProduto(rs.getInt("codigoProduto"));
				psid.setIdServico(rs.getInt("idServico"));
				ps.setId(psid);
				
				lista.add(ps);
			}
			return lista;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String cadastrar(ProdutoServicoDTO ps) {
		Connection conn = cn.getConexao();
		try {
			String query = "";
			query = "INSERT INTO tbProdutoServico(qtd,idServico,codigoProduto)"
					+ " VALUES"
					+ "	(?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, ps.getQtd());
			pstm.setInt(2, ps.getServicoId());
			pstm.setLong(3, ps.getProdutoId());
			pstm.execute();
			return "cadastrado com sucesso";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String apagarTd(ProdutoServicoDTO ps) {
		Connection conn = cn.getConexao();
		try {
			String query = "";
			query = "DELETE FROM tbProdutoServico"
					+ " WHERE idServico=?";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, ps.getServicoId());
			pstm.execute();
			return "Apagado com sucesso";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
