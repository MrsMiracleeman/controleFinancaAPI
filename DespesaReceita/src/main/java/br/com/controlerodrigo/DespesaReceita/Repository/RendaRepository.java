package br.com.controlerodrigo.DespesaReceita.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.controlerodrigo.DespesaReceita.Models.Renda;
import br.com.controlerodrigo.DespesaReceita.Models.Usuario;

@Repository
public interface RendaRepository extends CrudRepository <Renda, Long>{

	public List <Renda> findByUsuario (Usuario user);
	
	public List <Renda> findByUsuarioLogin (String login);


}
