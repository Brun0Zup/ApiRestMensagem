package com.br.apiRest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.apiRest.models.Mensagem;
import com.br.apiRest.services.MensagemService;

@RestController
@RequestMapping("/mensagens")
public class MensagensController {

	@Autowired
	MensagemService mensagemService;

	@GetMapping("/olaMundo")
	public ResponseEntity getOlaMundo() {
		return ResponseEntity.ok("Ola Mundo!");

	}

	@GetMapping
	public ResponseEntity pegarMensagens() {
		if (mensagemService.qtdMensagens() > 0) {
			return ResponseEntity.ok(mensagemService.pegarMensagens());
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> pegarMensagem(@PathVariable int id){
		
		
		try {
			Mensagem mensagem = mensagemService.pegarMensagemPeloId(id);
			return ResponseEntity.ok(mensagem);	
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
/*public ResponseEntity<?> criarMensagem(@Valid @RequestBody Mensagem mensagem){
	try {
	mensagemService.salvarMensagem(mensagem);
	return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);	
}catch(Exception e) {
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
}
*/
	@PostMapping
	public ResponseEntity<Mensagem> criarMensagem(@RequestBody Mensagem mensagem){
		try {
			mensagemService.salvarMensagem(mensagem);
			return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}

	@PutMapping("/{id}")
	public ResponseEntity<Mensagem> atualizarMensagem(@PathVariable int id, Mensagem mensagem){
			mensagemService.atualizarMensagem(id, mensagem);
			return ResponseEntity.ok(mensagem);	
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity apagarMensagem(@PathVariable int id) {
			mensagemService.apagarMensagem(id);
			return ResponseEntity.ok().build();
			
	}
		
}
