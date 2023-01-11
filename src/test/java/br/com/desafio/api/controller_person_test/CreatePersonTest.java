/**
 * Teste para a classe: {@link CreatePerson}
 *
 */
package br.com.desafio.api.controller_person_test;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.desafio.api.controller.person_control.CreatePerson;
import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.service.person_impl.SavePersonService;

@ExtendWith(MockitoExtension.class)
public class CreatePersonTest {
    @Mock
    private SavePersonService impl;

    @InjectMocks
    private CreatePerson createPerson;
    
    /**
     * validTestSave é responsável por testar se a chamada ao método 
     * save no createPerson irá chamar o método save no impl,
     * e verifica se o objeto person é passado como 
     * parâmetro para o método save
     */
    @Test
    public void validTestSave() {
        PersonEntity person = new PersonEntity();

        createPerson.save(person);

        verify(impl).save(person);
    }
}

