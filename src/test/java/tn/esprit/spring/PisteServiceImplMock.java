package tn.esprit.spring;

import static org.mockito.ArgumentMatchers.anyLong;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Color;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.entities.Skier;
import tn.esprit.spring.repositories.IPisteRepository;
import tn.esprit.spring.services.PisteServicesImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PisteServiceImplMock {

	@Mock
	IPisteRepository iPisteRepository;
	
	@InjectMocks
    PisteServicesImpl pistesService;

    @Test
    public void testRetrievePiste() {
        Piste piste = new Piste((long) 123, "piste 1", Color.RED, 1, 2, null);
        Mockito.when(iPisteRepository.findById(anyLong())).thenReturn(Optional.of(piste));
        Piste piste1 = pistesService.retrievePiste((long)1);
        Assertions.assertNotNull(piste1);
        
    }
}
