/**
 * Teste para a classe: {@link UpdatePerson}
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

import br.com.desafio.api.controller.person_control.UpdatePerson;
import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.service.person_impl.UpdatePersonService;

@ExtendWith(MockitoExtension.class)
	public class UpdatePersonTest {
	    @Mock
	    private UpdatePersonService impl;

	    @InjectMocks
	    private UpdatePerson updatePerson;
	    
	    /**
	     * validPersonUpdate é responsável por testar 
	     * se a chamada ao método personUpdate retorna 
	     * a pessoa atualizada esperada,
	     * e se o método updateData do impl 
	     * foi chamado com os parâmetros esperados
	     */
	    @Test
	    public void validPersonUpdate() throws Exception {
	        Long id = 123L;
	        PersonEntity person = new PersonEntity();
	        PersonEntity personUpdate = new PersonEntity();

	        when(impl.updateData(id, person)).thenReturn(personUpdate);

	        PersonEntity result = updatePerson.personUpdate(id, person);

	        assertEquals(personUpdate, result);
	        verify(impl).updateData(id, person);
	    }
	    
}
	
