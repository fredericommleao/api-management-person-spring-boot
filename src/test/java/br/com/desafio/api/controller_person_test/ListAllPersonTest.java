/**
 * Teste para a classe: {@link listAllPerson}
 *
 */
package br.com.desafio.api.controller_person_test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.desafio.api.controller.person_control.ListAllPerson;
import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.service.person_impl.FindAllPersonService;

@ExtendWith(MockitoExtension.class)
public class ListAllPersonTest {
    @Mock
    private FindAllPersonService impl;

    @InjectMocks
    private ListAllPerson listAllPerson;
    
   /**
    * validListAllPerson é responsável por testar se a 
    * chamada ao método listAllPerson retorna a 
    * lista de pessoas esperada
    * e se o método findAll do impl foi chamado
    */
    @Test
    public void validListAllPerson() {
        List<PersonEntity> pessoas = Arrays.asList(new PersonEntity(), new PersonEntity());

        when(impl.findAll()).thenReturn(pessoas);

        List<PersonEntity> result = listAllPerson.listAllPerson();

        assertEquals(pessoas, result);
        verify(impl).findAll();
    }
}

