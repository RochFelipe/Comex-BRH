package br.com.comex.sql.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.Pedido;
import br.com.comex.sql.factory.ConnectionFactory;
import br.com.comex.sql.modelo.dao.DAOPedido;

public class MainDAOPedido {
	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().criarConexao();
		
		SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
		Cliente cliente1 = new Cliente(8);
		
		Pedido pedido1 = new Pedido(spf.format(22-02-2022) ,cliente1);
		Pedido pedido2 = new Pedido(spf.format(19-10-2019) ,cliente1);
		
		DAOPedido daoPedido = new DAOPedido(connection);
		//daoPedido.salvarPedido(pedido1);
		//daoPedido.salvarPedido(pedido2);
		daoPedido.listarPedido();
		
	}
}
