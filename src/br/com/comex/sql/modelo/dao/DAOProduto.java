package br.com.comex.sql.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.enun.TipoProduto;

public class DAOProduto {
	private Connection connection;

	public DAOProduto(Connection connection) {
		this.connection = connection;
	}

	public void salvarProduto(Produto produto) throws SQLException {
		String sql = "INSERT INTO COMEX.PRODUTO( nome, descricao, preco_unitario, quantidade_estoque, categoria_id, tipo) VALUES ( ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.setDouble(3, produto.getPrecoUnitario());
			pstm.setInt(4, produto.getQtdEstoque());
			pstm.setInt(5, produto.getCategoriaProduto().getId());
			pstm.setString(6,produto.getTipo().name() );
			pstm.executeQuery();
			pstm.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro: " + ex);
			
		}
		

	}

	public List<Produto> listarProduto() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		String sql = "SELECT * FROM comex.produto";
		PreparedStatement pstm = connection.prepareStatement(sql);
		ResultSet rst = pstm.executeQuery();

		while (rst.next()) {
			Produto produto = this.populaProduto(rst);
			produtos.add(produto);
		}

		System.out.println("\n" +produtos);
		rst.close();		
		pstm.close();
		return produtos;
	}

	public void excluirProduto(int id) throws SQLException {
		String sql = "delete from comex.produto where id = ?";

		PreparedStatement pstm = connection.prepareStatement(sql);

		pstm.setInt(1, id);
		pstm.execute();

		pstm.close();
	}
	
	public void atualizaProduto(Produto produto) throws SQLException {
		String sql = "UPDATE comex.produto SET  NOME = ?, DESCRICAO = ?, PRECO_UNITARIO = ?, QUANTIDADE_ESTOQUE = ?, CATEGORIA_ID = ?, TIPO = ? ,ID = ?";
		
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.setDouble(3, produto.getPrecoUnitario());
			pstm.setInt(4, produto.getQtdEstoque());
			pstm.setInt(5, produto.getCategoriaProduto().getId());
			pstm.setString(6, String.valueOf(produto.getCategoriaProduto().getStatus()));
			pstm.setInt(7, produto.getId());
			pstm.executeQuery();
			pstm.close();

			System.out.println("Produto atualizado com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro ao atualizar produto: "+ ex);
			
		}		
	}
	
	private Produto populaProduto(ResultSet registros) throws SQLException {

		Produto produto = new Produto(registros.getString("NOME"), registros.getDouble("PRECO_UNITARIO"),
				registros.getString("DESCRICAO"), registros.getInt("QUANTIDADE_estoque"),
				new Categoria(registros.getInt("CATEGORIA_ID")),
				TipoProduto.valueOf(registros.getString("TIPO")));

		produto.setId(registros.getInt("ID"));
		return produto;
	}
}
