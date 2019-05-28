package br.com.drogariaWeb.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import com.mysql.cj.jdbc.Driver;

public class ConexaoFactory {
	private static final String USUARIO = "root";
	private static final String SENHA = "thermo";
	private static final String URL = "jdbc:mysql://localhost:3306/drogaria?useSSL=false&useTimezone=true&serverTimezone=UTC";
	
	public static Connection conectar() throws SQLException {
	
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}
//
//	public static void main(String[] args) {
//		try {
//			Connection conect = ConexaoFactory.conectar();
//			System.out.println("conex�o realizada com sucesso!");
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			System.out.println("N�o foi possivel realizar a conex�o com sucesso");
//		}
//	}

}
