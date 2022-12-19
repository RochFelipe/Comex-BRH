package br.com.comex.sql.factory;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	String url = "jdbc:oracle:thin:@172.17.0.2:1521:xe";
	String username = "system";
	String password = "admin";

	public DataSource dataSource;

	public ConnectionFactory() {
		try {
			ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
			comboPooledDataSource.setJdbcUrl(url);
			comboPooledDataSource.setUser(username);
			comboPooledDataSource.setPassword(password);
			this.dataSource = comboPooledDataSource;
		} catch (Exception ex) {
			System.err.println("Erro ao logar no banco de dados" + ex);
		}
	}

	public Connection criarConexao(){
		try {
			return this.dataSource.getConnection();
		} catch (Exception ex) {
			System.err.println("Erro inesperado enquanto pegava conexão " + ex);
		}
		return null;
	}

}
