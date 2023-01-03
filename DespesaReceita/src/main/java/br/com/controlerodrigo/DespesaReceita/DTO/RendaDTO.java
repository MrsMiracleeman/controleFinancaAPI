package br.com.controlerodrigo.DespesaReceita.DTO;

import br.com.controlerodrigo.DespesaReceita.Models.Renda;
import br.com.controlerodrigo.DespesaReceita.Models.Usuario;

public class RendaDTO extends Renda {

	private String login;
	private Usuario usuario;


	

	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}





	public Renda converter(RendaDTO rendaDto) {
		
		Renda renda = new Renda();
		
		renda.setNome(this.getNome());
		renda.setDescricao(rendaDto.getDescricao());
		renda.setValor(rendaDto.getValor());
		renda.setData(rendaDto.getData());
		renda.setUsuario(rendaDto.getUsuario());
		
//		
		return renda;
	}
}
