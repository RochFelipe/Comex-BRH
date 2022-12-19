package br.com.comex.sql.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.comex.modelo.ItemPedido;
import br.com.comex.modelo.Pedido;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.enun.TipoDesconto;
import br.com.comex.sql.factory.ConnectionFactory;
import br.com.comex.sql.modelo.dao.DAOItemPedido;

public class MainDAOItemPedido {
	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().criarConexao();
		
		ItemPedido itempedido1 = new ItemPedido(new Produto(28), 3523.00, 1,new Pedido(28),120, TipoDesconto.PROMOCAO );
		
		DAOItemPedido daoItemPedido = new DAOItemPedido(connection);
		//daoItemPedido.salvarItemPedido(itempedido1);
		daoItemPedido.listarItemPedido();
	}
}
