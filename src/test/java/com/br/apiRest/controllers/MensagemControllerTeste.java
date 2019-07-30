package com.br.apiRest.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.br.apiRest.models.Mensagem;
import com.br.apiRest.services.MensagemService;

@RunWith(SpringRunner.class)
@WebMvcTest(MensagensController.class)
public class MensagemControllerTeste {


	@Autowired
	private MockMvc mockMvc; // Simular que está fazendo equisição da API

	@MockBean // Criar uma versão falsa da contaService
	private MensagemService mensagemService;

@Test	
public void testaPegarMsgs() throws Exception {
	Mensagem mensagem = new Mensagem();
	
	mensagem = new Mensagem();
	mensagem.setId(null);
	mensagem.setConteudo("");
	
}
}
