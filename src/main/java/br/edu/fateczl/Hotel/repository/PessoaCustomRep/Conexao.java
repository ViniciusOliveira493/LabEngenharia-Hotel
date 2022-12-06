package br.edu.fateczl.Hotel.repository.PessoaCustomRep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private String server = "localhost";
	private String login = "SA";
	private String senha = "71.u5.qz";
	private String bd = "bdHotel";
	
	public Connection getConexao() {		
		return getConexaoSqlServer();		
	}
	
	public Connection getConexaoSqlServer() {
		String path = "jdbc:sqlserver://"+server+";"
        + "databaseName="+bd+";"
        + "user="+login+";"
        + "password="+senha+";"+
        "encrypt=true;trustServerCertificate=true";       
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(path);
			return conn;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void close(Connection cn) {
		try {
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
