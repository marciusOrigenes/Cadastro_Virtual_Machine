package br.com.minhaloja.modelo;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Produto {
	
	private Integer id;
	private String nome;
	private Integer memoria;
	private String sistemaOperacional;
	private Integer quantidade;
	
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", memoria=" + memoria + ", sistemaOperacional=" + sistemaOperacional
				+ ", quantidade=" + quantidade + "]";
	}
	
	public Integer getId() {
		return id;
	}
	
	@JsonIgnore
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getMemoria() {
		return memoria;
	}
	public void setMemoria(Integer memoria) {
		this.memoria = memoria;
	}
	public String getSistemaOperacional() {
		return sistemaOperacional;
	}
	public void setSistemaOperacional(String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
