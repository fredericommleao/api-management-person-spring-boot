/**
 * Teste para a classe: {@link ListByIdPersonService}
 *
 */
package br.com.desafio.api.service_person_test;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.exception.CustomException;
import br.com.desafio.api.repository.PersonRepository;
import br.com.desafio.api.service.person_impl.ListByIdPersonService;

@ExtendWith(MockitoExtension.class)
public class ListByIdPersonServiceTest {
    @Mock
    private PersonRepository personRepository;
    @InjectMocks
    private ListByIdPersonService service;
    private PersonEntity personEntity;

    @BeforeEach
    public void setup() {
        personEntity = new PersonEntity();
        personEntity.setNome("Fred");
        personEntity.setDataNascimento(LocalDate.of(2000, Month.FEBRUARY, 23));
    }
    
    /**
     * Teste que verifica se o método listbyId retorna uma pessoa válida
     * quando um Id válido é informado.
     * @throws CustomException 
     */
    @Test
    public void validListById() throws CustomException {
        Long id = 1L;
        when(personRepository.findById(id)).thenReturn(Optional.of(personEntity));
        PersonEntity returned = service.listbyId(id);
        assertEquals(returned.getNome(), personEntity.getNome());
        assertEquals(returned.getDataNascimento(), personEntity.getDataNascimento());
    }
    
    /**
     * Teste que verifica se o método listbyId lança uma exceção do tipo 
     * CustomException quando um Id inválido é informado.
     * @throws CustomException 
     */
    @Test
    public void validException() throws CustomException {
        Long id = 2L;
        when(personRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(CustomException.class, () -> service.listbyId(id));
    }
}

