package br.com.comex.sql.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.comex.sql.factory.ConnectionFactory;

public class MainIsercaoCategoria {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.criarConexao();
		
		Statement stm = connection.createStatement();
		
		stm.execute("INSERT INTO COMEX.CATEGORIA(nome, status) VALUES ('INFORMÁTICA', 'ATIVA')");
		stm.execute("INSERT INTO COMEX.CATEGORIA (nome, status) VALUES ('MÓVEIS', 'INATIVA')");
		stm.execute("INSERT INTO COMEX.CATEGORIA (nome, status) VALUES ('LIVROS', 'ATIVA')");
		
	connection.close();	
	}
}
