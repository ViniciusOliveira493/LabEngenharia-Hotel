package br.edu.fateczl.Hotel.repository.PessoaCustomRep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.edu.fateczl.Hotel.model.entity.PessoaID;


public class RepCustomPessoa {
	Conexao cn = new Conexao();
	public String senhaDoUsuario(PessoaID id){
		String a = null;
		try {
			Connection conn = cn.getConexao();

			String query = " select"
					+ "    senha"
					+ "  from"
					+ "    tbPessoa"
					+ "   where"
					+ "    documento=?"
					+ "    AND tipoDocumento=?";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, id.getDocumento());
			pstm.setInt(2, id.getTipoDocumento().getId());
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				a = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;		
	}
}
