package br.com.comex.sql.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.enun.TipoProduto;
import br.com.comex.sql.factory.ConnectionFactory;
import br.com.comex.sql.modelo.dao.DAOProduto;

public class MainDAOProduto {
	public static void main(String[] args) throws SQLException {

		Connection connection = new ConnectionFactory().criarConexao();

		Categoria informatica = new Categoria(214);
		Categoria livros = new Categoria(215);
		Categoria moveis = new Categoria(216);

		Produto produto1 = new Produto("Notebook Samsung", 3523,"Otimo para jogos",1, informatica,TipoProduto.NAO_ISENTO);
		Produto produto2 = new Produto("Sofá 3 lugares", 2500.00,"Otimo sofá", 1, moveis,TipoProduto.NAO_ISENTO);
		Produto produto3 = new Produto("Clean Architecture", 102.9,"Otimo livro", 2, livros,TipoProduto.NAO_ISENTO);

		DAOProduto daoProduto = new DAOProduto(connection);
		daoProduto.salvarProduto(produto1);
		daoProduto.salvarProduto(produto2);
		daoProduto.salvarProduto(produto3);
		//daoProduto.listarProduto();
	}

}
