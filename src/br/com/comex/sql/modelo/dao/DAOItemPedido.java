package br.com.comex.sql.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelo.ItemPedido;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.enun.TipoDesconto;
import br.com.comex.modelo.Pedido;

public class DAOItemPedido {
	private Connection connection;

	public DAOItemPedido(Connection connection) throws SQLException {
		this.connection = connection;}

	public void salvarItemPedido(ItemPedido itemPedido) throws SQLException {
		String sql = "INSERT INTO COMEX.ITEM_PEDIDO( preco_unitario, quantidade, produto_id, pedido_id, desconto, tipo_desconto) VALUES ( ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			
			pstm.setDouble(1, itemPedido.getPrecoUnitario());
			pstm.setInt(2, itemPedido.getQuantidade());
			pstm.setInt(3, itemPedido.getProduto().getId());
			pstm.setInt(4, itemPedido.getPedido().getId());
			pstm.setDouble(5, itemPedido.getDesconto());
			pstm.setString(6, itemPedido.getTipoDesconto().name());
			pstm.executeQuery();
			pstm.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro: " + ex);
		}	
	}

	public List<ItemPedido> listarItemPedido() throws SQLException {
		List<ItemPedido> itemPedidos = new ArrayList<ItemPedido>();
		String sql = "SELECT * FROM COMEX.ITEM_PEDIDO";
		PreparedStatement pstm = connection.prepareStatement(sql);
		ResultSet rst = pstm.executeQuery();

		while (rst.next()) {
			ItemPedido itemPedido = this.populaItemPedido(rst);
			itemPedidos.add(itemPedido);
		}
		
		System.out.println("\n" +itemPedidos);
		rst.close();		
		pstm.close();		
		return itemPedidos;
	}
	
	public void atualizaItemPedido(ItemPedido itemPedido) {
		String sql = "UPDATE comex.ITEM_PEDIDO SET preco_unitario = ?, quantidade = ?, produto_id = ?, "
				+ "pedido_id = ?, desconto = ?, tipo_desconto = ? where id = ?";

		try {

			PreparedStatement pstm = connection.prepareStatement(sql);

			
			pstm.setDouble(1, itemPedido.getPrecoUnitario());
			pstm.setInt(2, itemPedido.getQuantidade());
			pstm.setInt(3, itemPedido.getProduto().getId());
			pstm.setInt(4, itemPedido.getPedido().getId());
			pstm.setDouble(5, itemPedido.getDesconto());
			pstm.setString(6, itemPedido.getTipoDesconto().name());
			pstm.setInt(7, itemPedido.getId());

			pstm.execute();
			
			
			System.out.println("Item pedido atualizado com sucesso!!!");
			pstm.close();

		} catch (Exception erro) {

			System.out.println("Erro ao atualizar item pedido" + erro);

		}

	}
	
	private ItemPedido populaItemPedido (ResultSet registros) throws SQLException  {
		
		ItemPedido itemPedido = new ItemPedido(
				new Produto(registros.getInt("PRODUTO_ID")),
				registros.getDouble("PRECO_UNITARIO"),
				registros.getInt("QUANTIDADE"),								
				new Pedido(registros.getInt("PEDIDO_ID")),
				registros.getDouble("DESCONTO"),		
				TipoDesconto.valueOf(registros.getString("TIPO_DESCONTO")));
		itemPedido.setId(registros.getInt("ID"));
		return itemPedido;
	}
}
