package com.br.apiRest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.br.exception.MensagemNãoEncontradaException;
import com.br.helpers.DetailsErrors;

@ControllerAdvice
@RestController
public class MensagemControllerAdvice {
	
	@ExceptionHandler(MensagemNãoEncontradaException.class)

	public ResponseEntity<DetailsErrors> handleMensagemNãoEncontradaException(MensagemNãoEncontradaException e, 
			WebRequest requisicao){
		
		DetailsErrors detailsErrors = new DetailsErrors(e.getMessage(),
				requisicao.getDescription(false), HttpStatus.NOT_FOUND);
		
		return ResponseEntity.status(detailsErrors.getStatus()).body(detailsErrors);
	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	
	public ResponseEntity<DetailsErrors> handleMethodArgumentNotValidadException(MethodArgumentNotValidException e,
			WebRequest requisicao){
		DetailsErrors detailsErrors = new DetailsErrors(e.getMessage(),
				requisicao.getDescription(false),
				HttpStatus.BAD_REQUEST);
	
		return ResponseEntity.status(detailsErrors.getStatus()).body(detailsErrors);
	}
}
