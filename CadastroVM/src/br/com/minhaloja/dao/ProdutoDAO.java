package br.com.minhaloja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.minhaloja.modelo.Produto;

public class ProdutoDAO extends DBConexao {

	static Map<Integer, Produto> banco = new HashMap<>();
	static int id = 0;

	public Integer salvar(Produto produto) throws SQLException {

		// Estabelece conexão com o banco
		Connection conn = new DBConexao().conexao();
		// testa se a conexão foi efetuada com sucesso
		if (conn != null) {
			// Exibe mensagem de sucesso
			System.out.println("Conexão efetuada com sucesso!");

			// cria statement para executar a query
			String sql = "INSERT INTO tb_pedidos_vm (nome,sistema_operacional,quantidade,memoria) VALUES (?, ?,?,?)";

			PreparedStatement estado = conn.prepareStatement(sql);
			estado.setString(1, produto.getNome());
			estado.setString(2, produto.getSistemaOperacional());
			estado.setDouble(3, produto.getQuantidade());
			estado.setInt(4, produto.getMemoria());
			// executa o codigo
			estado.execute();

			// caso de problemas de conexão
		} else {
			System.out.println("Problemas de conexão!");
		}

		// encerra a conexão com o banco de dados
		try {
			conn.close();
			System.out.println("Conexão encerrada com sucesso!");
			// trata a excessão
		} catch (SQLException ex) {
			System.out.println("Erro ao encerrar conexão");
		}

		return produto.getId();
	}

	public Integer atualizar(int id, Produto produto) throws SQLException {

		// Estabelece conexão com o banco
		Connection conn = new DBConexao().conexao();
		// testa se a conexão foi efetuada com sucesso
		if (conn != null) {
			// Exibe mensagem de sucesso
			System.out.println("Conexão efetuada com sucesso!");

			// cria statement para executar a query
			String sql = "UPDATE tb_pedidos_vm SET nome = ?,sistema_operacional = ?,quantidade = ?,memoria = ? where id = ?";

			PreparedStatement estado = conn.prepareStatement(sql);
			estado.setString(1, produto.getNome());
			estado.setString(2, produto.getSistemaOperacional());
			estado.setDouble(3, produto.getQuantidade());
			estado.setInt(4, produto.getMemoria());
			estado.setInt(5, id);
			estado.execute();
			System.out.println("Usuário alterado com sucesso!");

			// trata a excessão
			System.out.println("Erro na execução do UPDATE");

			// caso de problemas de conexão
		} else {
			System.out.println("Problemas de conexão!");
		}

		// encerra a conexão com o banco de dados
		try {
			conn.close();
			System.out.println("Conexão encerrada com sucesso!");
			// trata a excessão
		} catch (SQLException ex) {
			System.out.println("Erro ao encerrar conexão");
		}
		return produto.getId();
	}

	public Produto get(Integer id) {
		return banco.get(id);
	}

	public Collection<Produto> list() throws SQLException {

		Connection conn = new DBConexao().conexao();
		String sql = "select * from tb_pedidos_vm";
		PreparedStatement estado = conn.prepareStatement(sql);

		// executa um select
		ResultSet rs = estado.executeQuery();

		List<Produto> vms = new ArrayList<>();
		// itera no ResultSet
		while (rs.next()) {

			// criando o objeto Contato
			Produto p = new Produto();
			p.setId(rs.getInt("id"));
			p.setNome(rs.getString("nome"));
			p.setSistemaOperacional(rs.getString("sistema_operacional"));
			p.setMemoria(rs.getInt("memoria"));
			p.setQuantidade(rs.getInt("quantidade"));

			// adicionando o objeto à lista
			vms.add(p);
		}
		rs.close();
		estado.close();
		conn.close();
		return vms;
	}

	public void deletar(int id) throws SQLException {
		// Estabelece conexão com o banco
		Connection conn = new DBConexao().conexao();
		// testa se a conexão foi efetuada com sucesso
		if (conn != null) {
			// Exibe mensagem de sucesso
			System.out.println("Conexão efetuada com sucesso!");

			// cria statement para executar a query
			String sql = "DELETE FROM tb_pedidos_vm where id =?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			System.out.println("Usuário deletado com sucesso!");

			// trata a excessão
			// caso de problemas de conexão
		} else {
			System.out.println("Problemas de conexão!");
		}

		// encerra a conexão com o banco de dados
		try {
			conn.close();
			System.out.println("Conexão encerrada com sucesso!");
			// trata a excessão
		} catch (SQLException ex) {
			System.out.println("Erro ao encerrar conexão");
		}
	}
}