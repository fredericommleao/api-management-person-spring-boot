/**
 * Teste para a classe: {@link CreateAddress}
 *
 */
package br.com.desafio.api.controller_address_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.desafio.api.controller.address_control.CreateAddress;
import br.com.desafio.api.domain.entity.AddressEntity;
import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.service.address_impl.CreateAddressService;

@ExtendWith(MockitoExtension.class)
public class CreateAddressTest {

    @Mock
    private CreateAddressService service;
    
    @InjectMocks
    private CreateAddress controller;
    private PersonEntity pessoa;
    private AddressEntity endereco;
    private Long id = 1L;
    
    /**
     * validCreateAddress é o metodo que ira testar se a chamada 
     * ao metodo createAddress no controller ira chamar o metodo 
     * createAddress no service e se o retorno 
     * esperado é igual ao endereco
     */
    
    @Test
    public void validCreateAddress() {
        AddressEntity result = controller.createAddress(id, endereco, pessoa);
        verify(service, times(1)).createAddress(pessoa, endereco, id);
        assertEquals(result, endereco);
    }
    
    
} 
    
    
    
    