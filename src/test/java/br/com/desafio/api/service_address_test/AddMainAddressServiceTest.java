/**
 * Teste para a classe: {@link AddMainAddressService}
 *
 */

package br.com.desafio.api.service_address_test;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatObject;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
import br.com.desafio.api.service.address_impl.AddMainAddressService;

@ExtendWith(MockitoExtension.class)
public class AddMainAddressServiceTest {
    @Mock
    private PersonRepository personRepository;
    @Mock
    private AddressRepository addressRepository;
    @InjectMocks
    private AddMainAddressService service;
    private PersonEntity personEntity;
    private AddressEntity addressEntity;
    private Long contactId = 1L;
    private Long addressId = 1L;

    @BeforeEach
    public void setup() {
        personEntity = new PersonEntity();
        personEntity.setNome("Fred");
        addressEntity = new AddressEntity();
        addressEntity.setLogradouro("rua 20");
    }
    
    /**

    O método mainAddress_nonExistentPerson_shouldThrowException testa se a 
    exceção é lançada quando o identificador da pessoa não existe.
    @throws CustomException se a pessoa não for encontrada
    */
    @Test
    public void validMainAddress() throws CustomException {
        when(personRepository.findById(contactId)).thenReturn(Optional.empty());
        when(addressRepository.findById(addressId)).thenReturn(Optional.of(addressEntity));
        try {
            service.mainAddress(contactId, addressId);
            fail("Expected exception");
        } catch (CustomException e) {
            // sucesso, exceção esperada
        }
    }
    
    /**

    O método validException 
    testa se a exceção é lançada quando o identificador do endereço não existe.
    @throws CustomException se o endereço não for encontrado
    */
    @Test
    public void validException() throws CustomException {
        when(personRepository.findById(contactId)).thenReturn(Optional.of(personEntity));
        when(addressRepository.findById(addressId)).thenReturn(Optional.empty());
        try {
            service.mainAddress(contactId, addressId);
            fail("Expected exception");
        } catch (CustomException e) {
            // sucesso, exceção esperada
        }
    }
}

