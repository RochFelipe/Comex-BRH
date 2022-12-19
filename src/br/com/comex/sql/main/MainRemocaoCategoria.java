package br.com.comex.sql.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.comex.modelo.enun.TipoStatus;
import br.com.comex.sql.factory.ConnectionFactory;

public class MainRemocaoCategoria {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.criarConexao();
		
		PreparedStatement stm = connection.prepareStatement("DELETE FROM COMEX.CATEGORIA WHERE STATUS = ?");
		stm.setString(1,String.valueOf(TipoStatus.INATIVA));
		stm.execute( );
		
		Integer linhasModificadas = stm.getUpdateCount();
		
		System.out.println("Quantidade de linhas modificadas: " + linhasModificadas);		
		
		connection.close();	
	}
}
