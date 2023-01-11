/**
 * Teste para a classe: {@link ListMainAddress}
 *
 */
package br.com.desafio.api.controller_address_test;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.desafio.api.controller.address_control.ListMainAddress;
import br.com.desafio.api.domain.entity.AddressEntity;
import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.service.address_impl.FindMainAddressService;

@ExtendWith(MockitoExtension.class)
public class ListMainAddressTest {

    @Mock
    private FindMainAddressService service;

    @InjectMocks
    private ListMainAddress controller;
    private Long id = 1L;
    private PersonEntity personEntity;
    private AddressEntity addressEntity;
    
    /**
     * validCallAddressPrimary é o 
     * metodo que ira testar se a chamada 
     * ao metodo callAddressPrimay no controller ira 
     * chamar o metodo findMainAddress no service e se o retorno 
     * esperado é igual a addressEntity
     */
    @Test
    public void validCallAddressPrimary() {
        when(service.findMainAddress(personEntity , id)).thenReturn(addressEntity);
        AddressEntity result = controller.callAddressPrimay(id, personEntity);
        verify(service, times(1)).findMainAddress(personEntity , id);
        assertEquals(result, addressEntity);
    }
}
