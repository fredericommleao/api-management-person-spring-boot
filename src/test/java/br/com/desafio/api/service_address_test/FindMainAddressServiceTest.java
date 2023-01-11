/**
 * Teste para a classe: {@link FindMainAddressService}
 *
 */
package br.com.desafio.api.service_address_test;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
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
import br.com.desafio.api.service.address_impl.FindMainAddressService;

@ExtendWith(MockitoExtension.class)
public class FindMainAddressServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private FindMainAddressService service;

    private PersonEntity personEntity;
    private AddressEntity addressEntity;
    private AddressEntity addressEntity2;
    private Long id = 1L;
    private LocalDate dataNascimento = LocalDate.of(2000, Month.FEBRUARY, 23);

    @BeforeEach
    public void setup() {
        personEntity = new PersonEntity();
        personEntity.setNome("Fred");
        personEntity.setDataNascimento(dataNascimento);
        addressEntity = new AddressEntity();
        addressEntity.setCidade("cidade 1");
        addressEntity.setPrincipal(false);
        addressEntity2 = new AddressEntity();
        addressEntity2.setCidade("cidade 2");
        addressEntity2.setPrincipal(true);
        personEntity.listAddress = Arrays.asList(addressEntity, addressEntity2);
    }
    
    /**
     * Testa se o endereço principal é retornado 
     * corretamente a partir dos dados de uma pessoa válida.
     */
    @Test
    public void validfindMainAddress()  {
        when(personRepository.findById(id)).thenReturn(Optional.of(personEntity));
        AddressEntity returned = service.findMainAddress(personEntity, id);
        assertEquals(returned, addressEntity2);
    }
    
    /**
     * Testa se é lançada uma exceção quando a pessoa buscada 
     * não existe no repositório.
     */
    @Test
    public void validException() {
    when(personRepository.findById(id)).thenReturn(Optional.empty());
    try {
    service.findMainAddress(personEntity, id);
    fail("Expected exception");
    } catch (CustomException e) {
   
    }
    }
}

