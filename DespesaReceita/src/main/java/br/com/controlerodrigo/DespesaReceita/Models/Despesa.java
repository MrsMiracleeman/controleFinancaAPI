package br.com.controlerodrigo.DespesaReceita.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Despesa {

	@Id
	private String nome;
	private String descricao;
	private Double valor;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
}
