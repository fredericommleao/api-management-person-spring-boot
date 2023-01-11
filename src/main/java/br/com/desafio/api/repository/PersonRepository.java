package br.com.desafio.api.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.desafio.api.domain.entity.PersonEntity;

public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

}
