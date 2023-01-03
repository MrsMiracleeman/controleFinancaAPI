package br.com.controlerodrigo.DespesaReceita.Models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Usuario {


	@Id
	private String login;
	private String senha;
	private String nome;
	private String sexo;
	private Double receita = 0.0;
	@JsonIgnore
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
	private List<Renda> renda = new ArrayList<Renda>();
//	
//	private List<Despesa> despesa = new ArrayList <Despesa>();
	
	
	
//	public Double addRenda (Double valor) {
//		
//		renda.forEach(null);
//		
//		return this.receita + valor;
//	} 
//	
//	
//	public void calcReceita () {
//		
//		this.renda.forEach(renda->{
//			this.receita += renda.getValor(); 
//		});
//		
//	}
	
	public String getLogin() {
		return login;
	}

	
	public List<Renda> getRenda() {
		return renda;
	}


	public void setRenda(List<Renda> renda) {
		this.renda = renda;
	}



	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Double getReceita() {
		return receita;
	}
	public void setReceita(Double receita) {
		this.receita = receita;
	}
	

	

	

	
	
	
	
}
