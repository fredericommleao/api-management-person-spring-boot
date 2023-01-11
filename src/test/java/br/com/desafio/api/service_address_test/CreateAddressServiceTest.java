/**
 * Teste para a classe: {@link CreateAddressService}
 *
 */
package br.com.desafio.api.service_address_test;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.fail;

import java.time.LocalDate;
import java.time.Month;
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
import br.com.desafio.api.repository.AddressRepository;
import br.com.desafio.api.repository.PersonRepository;
import br.com.desafio.api.service.address_impl.CreateAddressService;

@ExtendWith(MockitoExtension.class)
public class CreateAddressServiceTest {
    @Mock
    private AddressRepository addressRepository;
    @Mock
    private PersonRepository personRepository;
    @InjectMocks
    private CreateAddressService service;
    private PersonEntity personEntity;
    private AddressEntity addressEntity;
    private Long id = 1L;
    private LocalDate dataNascimento = LocalDate.of(2000, Month.FEBRUARY, 23);

    @BeforeEach
    public void setup() {
        personEntity = new PersonEntity();
        personEntity.setNome("Fred");
        personEntity.setDataNascimento(dataNascimento);
        addressEntity = new AddressEntity();
        addressEntity.setLogradouro("address 1");
    }

    /**
     * Testa se é lançada exceção caso a pessoa passada como 
     * parametro não exista no banco de dados
     */
    @Test
    public void validException() throws CustomException {
        when(personRepository.findById(id)).thenReturn(Optional.empty());
        try {
            service.createAddress(personEntity, addressEntity, id);
            fail("Exception was not thrown");
        } catch (CustomException e) {
            // assertion here
        }
    }

}
