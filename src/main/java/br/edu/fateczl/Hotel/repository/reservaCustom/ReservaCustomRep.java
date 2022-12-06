package br.edu.fateczl.Hotel.repository.reservaCustom;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.edu.fateczl.Hotel.model.dto.ReservaDTO;
import br.edu.fateczl.Hotel.repository.PessoaCustomRep.Conexao;

public class ReservaCustomRep {
	Conexao cn = new Conexao();
	
	public String criarReserva(ReservaDTO res) {
		Connection conn = cn.getConexao();
		String query = "";
		PreparedStatement pstm;
		try {
			if(res.getVaga().getTipo() == null) {
				System.out.println("SEM ESTACIONAMENTO");
				query = "INSERT INTO tbReserva(datafim,datainicio,documento,tipoDocumento,quartoId)"
						+ " VALUES"
						+ " (?,?,?,?,?)";
				pstm = conn.prepareStatement(query);
				pstm.setString(1, res.getDataFim());
				pstm.setString(2, res.getDataInicio());
				pstm.setString(3, res.getDocumento().getId().getDocumento());
				pstm.setInt(4, res.getDocumento().getId().getTipoDocumento().getId());
				pstm.setLong(5, res.getQuarto().getId());
			}else {
				System.out.println("COM ESTACIONAMENTO");
				query = "INSERT INTO tbReserva(datafim,datainicio,documento,tipoDocumento,quartoId,numVaga,estacionamento)"
						+ " VALUES"
						+ " (?,?,?,?,?,?,?)";
				pstm = conn.prepareStatement(query);
				pstm.setString(1, res.getDataFim());
				pstm.setString(2, res.getDataInicio());
				pstm.setString(3, res.getDocumento().getId().getDocumento());
				pstm.setInt(4, res.getDocumento().getId().getTipoDocumento().getId());
				pstm.setLong(5, res.getQuarto().getId());
				pstm.setInt(6, res.getVaga().getNumVaga());
				pstm.setString(7, res.getVaga().getEstacionamento());
			}
			pstm.execute();		
			return "Reserva realizada com sucesso";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String cancelarReserva(ReservaDTO res) {
		Connection conn = cn.getConexao();
		try {
			String query = "";
			query = "DELETE FROM tbReserva WHERE datafim=? AND datainicio=?"
					+ " AND documento = ? AND tipoDocumento=?";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, res.getDataFim());
			pstm.setString(2, res.getDataInicio());
			pstm.setString(3, res.getDocumento().getId().getDocumento());
			pstm.setInt(4, res.getDocumento().getId().getTipoDocumento().getId());
			
			pstm.execute();
			return "Apagado com sucesso";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
