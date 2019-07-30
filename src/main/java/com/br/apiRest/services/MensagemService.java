package com.br.apiRest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.br.apiRest.models.Mensagem;
import com.br.apiRest.repositories.MensagemRepository;
import com.br.exception.MensagemNãoEncontradaException;

@Service
public class MensagemService {

	@Autowired
	private MensagemRepository mensagemRepository;
	
	public Iterable<Mensagem> pegarMensagens(){
		return mensagemRepository.findAll();
	}
	
	public Mensagem pegarMensagemPeloId(int id) {
			return mensagemRepository.findById(id).get();
		
	}
	
	public void salvarMensagem(Mensagem mensagem) {
		mensagemRepository.save(mensagem);
		
	}
	
	public void atualizarMensagem(int id, Mensagem mensagem) {
		Optional<Mensagem> optionalMensagem = mensagemRepository.findById(id);
		//          if(optionalMensagem.empty())
		if(!optionalMensagem.isPresent()) {
			throw new MensagemNãoEncontradaException("Não há mensagens com esse ID");
		}
		
		mensagem.setId(id);
		mensagemRepository.save(mensagem);
	}
	
	public long qtdMensagens() {
		return  mensagemRepository.count();
	}
	
	public void apagarMensagem(int id) {
		try {
			mensagemRepository.deleteById(id);	
		}
		catch(EmptyResultDataAccessException e) {
			throw new MensagemNãoEncontradaException("Não há mensagem nesse ID");
		}
		
	}

	
}
