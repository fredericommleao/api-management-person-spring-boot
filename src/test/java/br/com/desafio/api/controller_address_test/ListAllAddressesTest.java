/**
 * Teste para a classe: {@link ListAllAddresses}
 *
 */
package br.com.desafio.api.controller_address_test;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.desafio.api.controller.address_control.ListAllAddresses;
import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.service.person_impl.FindAllAddressPersonService;

@ExtendWith(MockitoExtension.class)
public class ListAllAddressesTest {

    @Mock
    private FindAllAddressPersonService service;
    
    @InjectMocks
    private ListAllAddresses controller;
    private Long id = 1L;
    private PersonEntity personEntity;
    
    /**

    O método validFindAllAddress testa se a chamada 
    ao método findallAddress no controller
    irá chamar o método findAllAddress no service e se o retorno 
    esperado é igual a personEntity. Ele utiliza o método when
    para simular uma resposta do serviço, verify para verificar se 
    o método findAllAddress foi chamado exatamente uma vez,
    e assertEquals para comparar o retorno esperado com o retorno obtido.
    */
    @Test
    public void validFindAllAddress() {
        when(service.findAllAddress(id)).thenReturn(personEntity);
        PersonEntity result = controller.findallAddress(id);
        verify(service, times(1)).findAllAddress(id);
        assertEquals(result, personEntity);
    }
}

