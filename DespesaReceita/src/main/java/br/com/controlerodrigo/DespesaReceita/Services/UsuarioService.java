package br.com.controlerodrigo.DespesaReceita.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controlerodrigo.DespesaReceita.Models.Renda;
import br.com.controlerodrigo.DespesaReceita.Models.Usuario;
import br.com.controlerodrigo.DespesaReceita.Repository.RendaRepository;
import br.com.controlerodrigo.DespesaReceita.Repository.UsuarioRepository;


@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repository;
	
	@Autowired
	RendaRepository rendRep;
	
	
	//RETORNANDO TODOS OS USUARIOS
	public List<Usuario> get(){
		
		return (List<Usuario>) repository.findAll();
	}
	
	
	//RETORNANDO APENAS UM USUARIO//
	public Usuario findUser(String login) {
		
		repository.findByLogin(login);
		
		return repository.findByLogin(login);
	}
	
	
	//CRIANDO UM USUARIO
	public void post(Usuario usuario) {
		
		repository.save(usuario);
	}
	
	//ATUALIZANDO DADOS DE UM USUARIO
	public void update(String login, Usuario usuario) {
		
		Usuario user = repository.findByLogin(login);
		
		
		if(user.getNome() != usuario.getNome() && usuario.getNome() != null) {
			user.setNome(usuario.getNome());
		}
		
//		if(user.getReceita() != usuario.getReceita() && usuario.getReceita() != null) {
//			user.setReceita(usuario.getReceita());
//		}
		
		if(user.getSenha() != usuario.getSenha() && usuario.getSenha() != null) {
			user.setSenha(usuario.getSenha());
		}
		
		if(user.getSexo() != usuario.getSexo() && usuario.getSexo() !=null) {
			user.setSexo(usuario.getSexo());
		}
		
		
		repository.save(user);
	
		
	}
	
	//DELETANDO UM USUARIO
	public void delete(String login) {
		
		rendRep.findByUsuario(repository.findByLogin(login)).forEach(renda->{
			rendRep.delete(renda);
		});
		
		repository.delete(repository.findByLogin(login));
		
	}
	
	//Calculando Receita
	public void AddRenda (Usuario user, Renda renda) {
			
		user.setReceita(user.getReceita() + renda.getValor());
		
		repository.save(user);
		
	} 

	
}
