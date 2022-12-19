package br.com.comex.sql.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.comex.sql.factory.ConnectionFactory;

public class MainListagemCategoria {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.criarConexao();
		
		Statement stm = connection.createStatement();
		
		stm.execute("SELECT ID, NOME, STATUS FROM comex.categoria");
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Integer id = rst.getInt("ID");			
			String nome =rst.getString("NOME");			
			String status =rst.getString("STATUS");
			System.out.println( id+ " | "+nome+ " | "+status);
			
		}
		connection.close();	
	}
}
