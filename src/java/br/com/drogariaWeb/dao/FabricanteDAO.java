package br.com.drogariaWeb.dao;

import br.com.drogariaWeb.domain.Fabricante;
import br.com.drogariaWeb.factory.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.model.ListDataModel;




public class FabricanteDAO {
	public void salvar(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fabricante ");
		sql.append("(descricao) ");
		sql.append("VALUES(?)");
		Connection conect = ConexaoFactory.conectar();

		PreparedStatement comando = conect.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.executeUpdate();

	}

	public void excluir(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fabricante ");
		sql.append("WHERE codigo = ? ");

		Connection conect = ConexaoFactory.conectar();
		PreparedStatement comando = conect.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());

		comando.executeUpdate();

	}

	public void editar(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fabricante ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE codigo = ? ");

		Connection conect = ConexaoFactory.conectar();
		PreparedStatement comando = conect.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setLong(2, f.getCodigo());

		comando.executeUpdate();

	}

	public ArrayList<Fabricante> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("ORDER BY descricao ASC ");

		Connection conect = ConexaoFactory.conectar();
		PreparedStatement comando = conect.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();
		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();

		while (resultado.next()) {
			Fabricante f = new Fabricante();
			f.setCodigo(resultado.getLong("codigo"));
			f.setDescricao(resultado.getString("descricao"));

			lista.add(f);
		}
		return lista;

	}

	public ArrayList<Fabricante> buscarPorDescricao(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("WHERE descricao LIKE ?");
		sql.append("ORDER BY descricao ASC ");

		Connection conect = ConexaoFactory.conectar();

		PreparedStatement comando = conect.prepareStatement(sql.toString());
		comando.setString(1, "%" + f.getDescricao() + "%");

		ResultSet resultado = comando.executeQuery();
		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();

		while (resultado.next()) {
			Fabricante item = new Fabricante();
			item.setCodigo(resultado.getLong("codigo"));
			item.setDescricao(resultado.getString("descricao"));

			lista.add(item);
		}
		return lista;

	}

	public Fabricante buscarPorCodigo(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("WHERE codigo = ? ");

		Connection conect = ConexaoFactory.conectar();

		PreparedStatement comando = conect.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());

		ResultSet resultado = comando.executeQuery();

		Fabricante retorno = null;

		if (resultado.next()) {
			retorno = new Fabricante();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));
		}

		return retorno;

	}
        

//	public static void main(String[] args) {
//
////		
////		Fabricante f2 = new Fabricante();
////		f2.setDescricao("agora");
//////		
////		FabricanteDAO fdao = new FabricanteDAO();
////		try {
////			ArrayList<Fabricante> lista = fdao.buscarPorDescricao(f2);
////			for (Fabricante f: lista) {
////				System.out.println("resultado: "+f);
////				
////			}
////		} catch (SQLException e) {
////			System.out.println("ocorreu um erro na consulta");
////			e.printStackTrace();
////		}
////		
//		try {
//			FabricanteDAO dao = new FabricanteDAO();
//			
//			ArrayList<Fabricante> lista = dao.listar();
//			for (Fabricante f: lista) {
//				System.out.println("resultado: "+f);
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
}
