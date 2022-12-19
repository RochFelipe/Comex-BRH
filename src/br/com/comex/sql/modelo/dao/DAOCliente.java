package br.com.comex.sql.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelo.Cliente;

public class DAOCliente {
	private Connection connection;

	public DAOCliente(Connection connection) {
		this.connection = connection;
	}


	public void salvarCliente(Cliente cliente) throws SQLException {
		String sql = "INSERT INTO COMEX.CLIENTE( nome, cpf, telefone, rua, numero, complemento, bairro, cidade, uf)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstm = connection.prepareStatement(sql)){;
		
		pstm.setString(1, cliente.getNome());
		pstm.setString(2, cliente.getCpf());
		pstm.setString(3, cliente.getTelefone());
		pstm.setString(4, cliente.getRua());
		pstm.setString(5, cliente.getNumero());
		pstm.setString(6, cliente.getComplemento());
		pstm.setString(7, cliente.getBairro());
		pstm.setString(8, cliente.getCidade());
		pstm.setString(9, cliente.getEstado());
		pstm.executeQuery();
		pstm.close();
		}catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro ao salvar cliente: "+ ex);
			
		}		
	}

	public List<Cliente> listarCliente() throws SQLException {
		List<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM comex.cliente";
		PreparedStatement pstm = connection.prepareStatement(sql);
		ResultSet rst = pstm.executeQuery();
		while (rst.next()) {
			Cliente cliente = this.populaCliente(rst);
			clientes.add(cliente);
		}
		System.out.println("\n" +clientes);
		rst.close();		
		pstm.close();
		return clientes;
	}
	public void excluirCliente (int id) throws SQLException {
		String sql = "DELETE FROM comex.cliente WHERE id = ?";
		
		PreparedStatement pstm = connection.prepareStatement(sql);
		
		pstm.setInt(1, id);
		pstm.executeQuery();
		pstm.close();
	}
	
	public void atualizaCliente(Cliente cliente) throws SQLException {
		String sql = "UPDATE comex.cliente SET  NOME = ?, CPF = ? , TELEFONE = ?, RUA = ?, NUMERO = ?, COMPLEMENTO = ?, BAIRRO = ?, CIDADE = ?, UF = ?, ID = ? ";
		
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCpf());
			pstm.setString(3, cliente.getTelefone());
			pstm.setString(4, cliente.getRua());
			pstm.setString(5, cliente.getNumero());
			pstm.setString(6, cliente.getComplemento());
			pstm.setString(7, cliente.getBairro());
			pstm.setString(8, cliente.getCidade());
			pstm.setString(9, cliente.getEstado());
			pstm.setInt(10, cliente.getId());
			pstm.executeQuery();
			pstm.close();

			
			
			System.out.println("Cliente atualizad com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro ao atualizar cliente: "+ ex);
			
		}			
	}
	
	private Cliente populaCliente(ResultSet registros) throws SQLException {

		Cliente cliente = new Cliente(registros.getString("NOME"),
				registros.getString("CPF"),
				registros.getString("TELEFONE"),
				registros.getString("RUA"),
				registros.getString("NUMERO"),
				registros.getString("COMPLEMENTO"),
				registros.getString("BAIRRO"),
				registros.getString("CIDADE"),
				registros.getString("UF"));
		
		cliente.setId(registros.getInt("ID"));
		return cliente;
	}
}
