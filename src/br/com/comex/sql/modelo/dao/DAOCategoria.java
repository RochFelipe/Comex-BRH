package br.com.comex.sql.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.enun.TipoStatus;

public class DAOCategoria {
	private Connection connection;

	public DAOCategoria(Connection connection) {
		this.connection = connection;
	}

	public void salvarCategoria(Categoria categoria) {

        String sql = "INSERT INTO comex.CATEGORIA(nome, status)" + "VALUES (?, ?)";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setString(1, categoria.getNome());
            pstm.setString(2, categoria.getStatus().name());
            pstm.executeQuery();

            System.out.println("Categoria inserida com sucesso!!!");

            pstm.close();

        } catch (Exception erro) {
            System.out.println("Erro ao salvar " + erro);

        } 
    } 

	public List<Categoria> listarCategoria() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		String sql = "SELECT * FROM comex.Categoria";
		PreparedStatement pstm = connection.prepareStatement(sql);
		ResultSet rst = pstm.executeQuery();

		while (rst.next()) {
			Categoria categoria = this.populaCategoria(rst);
			categorias.add(categoria);
		}
		System.out.println("\n" +categorias);
		rst.close();		
		pstm.close();
		return categorias;
	}

	public void excluirCategoria(int id) throws SQLException {
		String sql = "DELETE FROM COMEX.CATEGORIA WHERE STATUS = ?";

		PreparedStatement pstm = connection.prepareStatement(sql);

		pstm.setInt(1, id);
		pstm.executeQuery();
		pstm.close();
		
	}

	public void atualizaCategoria(Categoria categoria) throws SQLException {
		String sql = "UPDATE comex.categoria SET ID = ?, NOME = ?, STATUS = ?,ID = ? ";
		
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, categoria.getNome());
			pstm.setString(2, categoria.getStatus().name());
			pstm.setInt(3, categoria.getId());
			pstm.executeQuery();
			pstm.close();
			System.out.println("Categoria atualizada com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro ao atualizar categoria: " + ex);

		}
	}

	private Categoria populaCategoria(ResultSet registros) throws SQLException {
		Categoria categoria = new Categoria(registros.getString("NOME"),TipoStatus.valueOf(registros.getString("STATUS")));

		categoria.setId(registros.getInt("ID"));
		return categoria;
	}
}
