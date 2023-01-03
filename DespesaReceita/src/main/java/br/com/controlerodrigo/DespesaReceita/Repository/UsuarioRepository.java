package br.com.controlerodrigo.DespesaReceita.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.controlerodrigo.DespesaReceita.Models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository <Usuario, String> {

	public Usuario findByLogin(String login);
	
}
