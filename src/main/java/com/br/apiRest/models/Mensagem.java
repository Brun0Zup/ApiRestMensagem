package com.br.apiRest.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Mensagem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "O campo conteúdo é obrigatório")
	private String conteudo;

	
	private String conteudoParaSerAdcionado;


	public Mensagem() {
		super();
	}


	public Mensagem(Integer id, @NotBlank(message = "O campo conteúdo é obrigatório") String conteudo,
			String conteudoParaSerAdcionado) {
		super();
		this.id = id;
		this.conteudo = conteudo;
		this.conteudoParaSerAdcionado = conteudoParaSerAdcionado;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getConteudo() {
		return conteudo;
	}


	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}


	public String getConteudoParaSerAdcionado() {
		return conteudoParaSerAdcionado;
	}


	public void setConteudoParaSerAdcionado(String conteudoParaSerAdcionado) {
		this.conteudoParaSerAdcionado = conteudoParaSerAdcionado;
	}
	
	
	
	
	
	

}
