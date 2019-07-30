package com.br.apiRest.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ApiTest {

	
	private Mensagem mensagem;
	
	@Before
	public void adcionandoMensagem() {
		
		mensagem = new Mensagem();
		mensagem.setId(null);
		mensagem.setConteudo("");
		
	}
	@Test
		public void adcionarConteudo() {
		assertEquals("", mensagem.getConteudo());
		
		}
	
	}

