package br.com.controlerodrigo.DespesaReceita.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controlerodrigo.DespesaReceita.DTO.RendaDTO;
import br.com.controlerodrigo.DespesaReceita.Models.Renda;
import br.com.controlerodrigo.DespesaReceita.Models.Usuario;
import br.com.controlerodrigo.DespesaReceita.Repository.RendaRepository;
import br.com.controlerodrigo.DespesaReceita.Repository.UsuarioRepository;

@Service
public class RendaService {

	
	@Autowired
	RendaRepository repository;
	
	
	@Autowired
	UsuarioRepository usuarioRep;
	
	@Autowired
	UsuarioService usuarioServ;
	
	
	//MÉTODO PARA CADASTRAR RENDA NO SISTEMA
	public void post (RendaDTO rendaDto) {
		
		Iterable <Usuario> users = usuarioRep.findAll();
		users.forEach(usuario->{
			if(usuario.getLogin().equals(rendaDto.getLogin())) {
				rendaDto.setUsuario(usuario);
				repository.save(rendaDto.converter(rendaDto));
				usuarioServ.AddRenda(usuario, rendaDto.converter(rendaDto));
			}
		});
		
		
		
	}
	
	//MÉTODO PARA LISTAR TODAS AS RENDAS DO SISTEMA
	public List <Renda> get(){
		
		return (List<Renda>) repository.findAll();
	}

	//MÉTODO PARA REALIZAR UMA ATUALIZAÇÃO DE DADOS DE UMA RENDA EM ESPECÍFICO (PASSANDO O ID DA RENDA)
	public void update(Long id, Renda renda) {
		
		 repository.findById(id).stream().forEach(rendas->{
			 if(rendas.getId() == id) {
				 if(rendas.getNome() != renda.getNome() && renda.getNome() != null) {
					 rendas.setNome(renda.getNome());
					 
				 }
				 
				 if(rendas.getDescricao() != renda.getDescricao() && renda.getDescricao() != null) {
					 rendas.setDescricao(renda.getDescricao());
				 }
				 
				 if(rendas.getValor() != renda.getValor() && renda.getValor() != null) {
					 Usuario user = usuarioRep.findByLogin(rendas.getUsuario().getLogin());
					 user.setReceita(user.getReceita() - rendas.getValor());
					 user.setReceita(user.getReceita() + renda.getValor());
					 rendas.setValor(renda.getValor());
					 	 
					 usuarioServ.post(user);
				 }
				 
			 		
				 repository.save(rendas);
			 }
		 });	
	}

	//MÉTODO PARA DELETAR UMA RENDA EM RESPECÍFICO (PASSANDO O ID DA RENDA)
	public void deleteRenda(Long id) {
		
		repository.findById(id).stream().forEach(rendas->{
			if(rendas.getId() == id) {
				 Usuario user = usuarioRep.findByLogin(rendas.getUsuario().getLogin());
				 user.setReceita(user.getReceita() - rendas.getValor());
				 usuarioServ.post(user);
				repository.delete(rendas);	
				
				
			}
		});
		
	}
	
	//MÉTODO PARA UMA LISTA DE RENDAS DE UM DETERMINADO USUARIO
	public List <Renda> getRendaUsuario (String login) {

		Iterable <Renda> lista = repository.findByUsuarioLogin(login);
		
		return (List<Renda>) lista;
		
	}
	
}
