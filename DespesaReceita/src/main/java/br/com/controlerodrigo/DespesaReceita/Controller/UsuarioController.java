package br.com.controlerodrigo.DespesaReceita.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlerodrigo.DespesaReceita.Models.Usuario;
import br.com.controlerodrigo.DespesaReceita.Repository.UsuarioRepository;
import br.com.controlerodrigo.DespesaReceita.Services.UsuarioService;
import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService userService;
	
	@GetMapping()
	public List<Usuario> getUsuarios(String login) {
		return userService.get();
	}
	
	@GetMapping("/{login}")
	public Usuario getUsuario (@PathVariable String login) {
		
		return userService.findUser(login);
	}
	
	@PostMapping()
	public void postUsuario(@RequestBody Usuario usuario) {
		userService.post(usuario);
	}
	
	@PutMapping("/{login}")
	public void updateUsuario(@PathVariable String login, @RequestBody Usuario usuario) {
		userService.update(login,usuario);
	}
	
	@DeleteMapping("/{login}")
	public void deleteUsuario (@PathVariable String login) {
		userService.delete(login);
	}
}
