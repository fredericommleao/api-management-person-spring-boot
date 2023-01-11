package br.com.desafio.api.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.desafio.api.domain.entity.AddressEntity;

public interface AddressRepository extends CrudRepository<AddressEntity, Long>{

}
