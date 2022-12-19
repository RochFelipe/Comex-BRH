package br.com.comex.sql.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.comex.sql.factory.ConnectionFactory;
import br.com.comex.sql.modelo.dao.DAOCliente;
import br.com.comex.modelo.Cliente;

public class MainDAOCliente {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().criarConexao();
		
		Cliente cliente1 = new Cliente("Anna Carolina", "111.111.111-11", "(81) 9 8878-5225", "rua 123", "21", "CASA C", "Torrões", "Recife", "PE");
		
		DAOCliente daoCliente = new DAOCliente(connection);
		daoCliente.salvarCliente(cliente1);
		//daoCliente.listarCliente();
		//daoCliente.excluirCliente(1);
	}
}
