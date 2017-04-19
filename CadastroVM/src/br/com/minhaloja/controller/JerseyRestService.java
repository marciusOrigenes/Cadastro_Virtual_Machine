package br.com.minhaloja.controller;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.minhaloja.dao.ProdutoDAO;
import br.com.minhaloja.modelo.Produto;

@Path("/produto")
public class JerseyRestService {

	private ProdutoDAO p = new ProdutoDAO();

	@POST
	@Path("/novo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response salvarDados(Produto produto) {
		try {
			p.salvar(produto);
			return Response.status(200).entity(produto).build();
		} catch (SQLException e) {
			return Response.status(404).entity("{'Erro ao salvar!'}").build();
		}
	}

	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDados() throws SQLException {

		return Response.status(200).entity(p.list()).build();
	}

	@PUT
	@Path("/atualizar/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizarDados(@PathParam("id") Integer id, Produto produto) {
		try {
			p.atualizar(id, produto);
		} catch (SQLException e) {
			return Response.status(404).entity("{'Erro ao atualizar!'}").build();
		}

		return Response.status(200).entity(produto).build();
	}

	@DELETE
	@Path("/deletar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletarDados(@PathParam("id") Integer id) {
		try {
			p.deletar(id);
			return Response.status(200).entity(id).build();
		} catch (SQLException e) {
			return Response.status(404).entity("{'Erro ao deletar!'}").build();
		}
	}
}
