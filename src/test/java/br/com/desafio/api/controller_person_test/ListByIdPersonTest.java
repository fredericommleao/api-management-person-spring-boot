/**
 * Teste para a classe: {@link ListByIdPerson}
 *
 */
package br.com.desafio.api.controller_person_test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.desafio.api.controller.person_control.ListByIdPerson;
import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.service.person_impl.ListByIdPersonService;

@ExtendWith(MockitoExtension.class)
public class ListByIdPersonTest {
    @Mock
    private ListByIdPersonService pessoaService;

    @InjectMocks
    private ListByIdPerson listByIdPerson;
    
   /**
    * validListById é responsável por testar se a 
    * chamada ao método listById retorna a 
    * pessoa esperada pelo id especificado,
    * e se o método listbyId do pessoaService foi chamado
    */
    @Test
    public void validListById() {
        Long id = 123L;
        PersonEntity pessoa = new PersonEntity();

        when(pessoaService.listbyId(id)).thenReturn(pessoa);

        PersonEntity result = listByIdPerson.listById(id);

        assertEquals(pessoa, result);
        verify(pessoaService).listbyId(id);
    }
}
