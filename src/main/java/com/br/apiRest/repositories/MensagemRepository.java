package com.br.apiRest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.apiRest.models.Mensagem;

@Repository
public interface MensagemRepository extends CrudRepository<Mensagem, Integer>{

}
