/**
 * Teste para a classe: {@link SavePersonService}
 *
 */
package br.com.desafio.api.service_person_test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.repository.PersonRepository;
import br.com.desafio.api.service.person_impl.SavePersonService;

@ExtendWith(MockitoExtension.class)
public class SavePersonServiceTest {
    @Mock
    private PersonRepository personRepository;
    @InjectMocks
    private SavePersonService service;
    private PersonEntity personEntity;
    
    
    /**
     * Testa se a pessoa é salva corretamente
     */
    @Test
    public void validSave() {
        service.save(personEntity);
        verify(personRepository, times(1)).save(personEntity);
    }
}
