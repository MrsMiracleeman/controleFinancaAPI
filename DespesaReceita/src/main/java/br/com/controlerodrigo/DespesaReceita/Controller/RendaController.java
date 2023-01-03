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

import br.com.controlerodrigo.DespesaReceita.DTO.RendaDTO;
import br.com.controlerodrigo.DespesaReceita.Models.Renda;
import br.com.controlerodrigo.DespesaReceita.Models.Usuario;
import br.com.controlerodrigo.DespesaReceita.Repository.UsuarioRepository;
import br.com.controlerodrigo.DespesaReceita.Services.RendaService;
import jakarta.websocket.server.PathParam;



@RestController
@RequestMapping("/renda")
public class RendaController {
	
	@Autowired
	RendaService service;
	
	@Autowired
	UsuarioRepository repository;
	
	
	@PostMapping()
	public void postRenda(@RequestBody RendaDTO rendaDto) {
		service.post(rendaDto);
	}
	
	
	@GetMapping()
	public List <Renda> getRenda(String rendaslogin) {
		if(rendaslogin == null) {
			return service.get();
		}else {
			return service.getRendaUsuario(rendaslogin);
		}
	}
	
	@PutMapping("/{id}")
	public void updateRenda(@PathVariable Long id, @RequestBody Renda renda) {
		
		service.update(id,renda);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRenda(@PathVariable Long id) {
		
		service.deleteRenda(id);
	}
	

}
