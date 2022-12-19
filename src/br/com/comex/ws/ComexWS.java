package br.com.comex.ws;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.comex.sql.factory.ConnectionFactory;
import br.com.comex.sql.modelo.dao.DAOCategoria;
import br.com.comex.sql.modelo.dao.DAOCliente;
import br.com.comex.sql.modelo.dao.DAOProduto;
import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.Produto;

@WebService
public class ComexWS {
	Connection conexao = new ConnectionFactory().criarConexao();

	DAOCategoria daoCategoria = new DAOCategoria(conexao);
	DAOCliente daoCliente = new DAOCliente(conexao);
	DAOProduto daoProduto =  new DAOProduto(conexao);
	// -------------- Categoria -------------- \\
	@WebMethod(operationName = "ListarCategorias")
	@WebResult(name = "categoria")
	public List<Categoria> getCategorias() throws SQLException {

		List<Categoria> categorias = daoCategoria.listarCategoria();

		return categorias;

	}
	@WebMethod(operationName = "CadastrarCategoria")
	@WebResult(name = "categoria")
	public Categoria adicionarCategoria(@WebParam(name = "categoria") Categoria categoria) {
		daoCategoria.salvarCategoria(categoria);
		return categoria;
	}
	
	// -------------- Cliente -------------- \\

	@WebMethod(operationName = "ListarClientes")
	@WebResult(name = "cliente")
	public List<Cliente> getClientes() throws SQLException {

		List<Cliente> clientes = daoCliente.listarCliente();

		return clientes;

	}
	@WebMethod(operationName = "CadastrarCliente")
	@WebResult(name = "cliente")
	public Cliente adicionarCliente (@WebParam(name = "cliente") Cliente cliente) throws SQLException {
		daoCliente.salvarCliente(cliente);
		return cliente;
	}
	// -------------- Produto -------------- \\
	@WebMethod(operationName = "ListarProduto")
	@WebResult(name = "produto")
	public List<Produto> getProduto() throws SQLException {

		List<Produto> produtos = daoProduto.listarProduto();

		return produtos;

	}
	@WebMethod(operationName = "AdicionarProduto")
	@WebResult(name = "produto")
	public Produto adicionarProduto(@WebParam(name = "produto") Produto produto) throws SQLException {
		daoProduto.salvarProduto(produto);
		return produto;
	}
	
}
