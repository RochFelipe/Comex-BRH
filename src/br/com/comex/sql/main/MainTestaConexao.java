package br.com.comex.sql.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.comex.sql.factory.ConnectionFactory;

public class MainTestaConexao {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.criarConexao();
		
		System.out.println("Conexão efetuada com sucesso");
		
		connection.close();
		
	}
	
}
