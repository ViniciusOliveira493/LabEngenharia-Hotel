package br.edu.fateczl.Hotel.repository.VagasCustom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.Hotel.model.dto.VagaDTO;
import br.edu.fateczl.Hotel.model.entity.TipoVaga;
import br.edu.fateczl.Hotel.repository.PessoaCustomRep.Conexao;

public class RepCustomVagas {
	Conexao cn = new Conexao();
	public List<VagaDTO> findVagasPorEstacionamento(String estacionamento){
		List<VagaDTO> vagas = new ArrayList<VagaDTO>();
		try {
			Connection conn = cn.getConexao();	        
			String query = "SELECT "
					+ "	estacionamento"
					+ " ,numVaga"
					+ " ,descricao"
					+ " ,tipo"
					+ " ,valorDiaria"
					+ " FROM tbVaga"
					+ "	WHERE estacionamento=?";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, estacionamento);
			ResultSet rs = pstm.executeQuery();			
			while(rs.next()) {
				VagaDTO v = new VagaDTO();
				v.setDescricao(rs.getString("descricao"));
				v.setEstacionamento(rs.getString("estacionamento"));
				v.setNumVaga(rs.getInt("numVaga"));
				v.setValorDiaria(rs.getDouble("valorDiaria"));
				TipoVaga tv = new TipoVaga();
				tv.setId(rs.getInt("tipo"));
				v.setTipo(tv.toDTO());
				vagas.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vagas;
	}
}
