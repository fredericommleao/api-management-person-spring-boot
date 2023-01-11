/**
 * Teste para a classe: {@link FindAllAddressPersonService}
 *
 */
package br.com.desafio.api.service_person_test;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.desafio.api.domain.entity.AddressEntity;
import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.exception.CustomException;
import br.com.desafio.api.repository.PersonRepository;
import br.com.desafio.api.service.person_impl.FindAllAddressPersonService;

@ExtendWith(MockitoExtension.class)
public class FindAllAddressPersonServiceTest {
    @Mock
    private PersonRepository personRepository;
    @InjectMocks
    private FindAllAddressPersonService service;
    private PersonEntity personEntity;
    private Long id = 1L;
    private LocalDate dataNascimento = LocalDate.of(2000, Month.FEBRUARY, 23);

    @BeforeEach
    public void setup() {
        personEntity = new PersonEntity();
        personEntity.setNome("Fred");
        personEntity.setDataNascimento(dataNascimento);
        personEntity.setAddress(Collections.singletonList(new AddressEntity("Endereco 1")));
    }
    
    /**
    Método que testa se a pessoa é encontrada 
    com sucesso pelo ID. Esse método retorna a pessoa encontrada
    e verifica se os atributos da pessoa encontrada 
    são iguais à pessoa criada no setup.
    @throws CustomException
    */
    @Test
    public void validFindAllAddress() throws CustomException {
        when(personRepository.findById(id)).thenReturn(Optional.of(personEntity));
        PersonEntity returned = service.findAllAddress(id);
        assertEquals(returned.getNome(), personEntity.getNome());
        assertEquals(returned.getDataNascimento(), personEntity.getDataNascimento());
        assertEquals(returned.listAddress, personEntity.listAddress);
    }
    
    /**

    Método que testa se a pessoa não é encontrada pelo ID. 
    Esse método deve lançar uma exceção CustomException
    pois a pessoa não foi encontrada.
    */
    @Test
    public void validException() 
    	throws CustomException {
    when(personRepository.findById(id)).thenReturn(Optional.empty());
    try {
        service.findAllAddress(id);
        fail("Expected CustomException");
    } catch (CustomException e) {
        e.getMessage();
    }}
 }

