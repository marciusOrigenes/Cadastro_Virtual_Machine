package br.com.minhaloja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConexao {
	public Connection conexao() {
		String driver = "org.postgresql.Driver";
		String user = "postgres";
		String senha = "LKJ@09poc";
		String url = "jdbc:postgresql://localhost:5432/db_VirtualMachine";
		try {
			Class.forName(driver);
			Connection con = null;
			con = (Connection) DriverManager.getConnection(url, user, senha);
			System.out.println("Conexão realizada com sucesso.");
			return con;
		} catch (ClassNotFoundException ex) {
			System.err.print(ex.getMessage());
			return null;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			return null;
		}
	}
}