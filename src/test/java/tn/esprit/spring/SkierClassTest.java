package tn.esprit.spring;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repositories.*;
import tn.esprit.spring.services.*;

@SpringBootTest
 class SkierClassTest {

    @InjectMocks
    private SkierServicesImpl skierService;

    @Mock
    private ISkierRepository skierRepository;

    @Mock
    private ISubscriptionRepository subRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddSkier() {
        Skier skier = new Skier();
        when(skierRepository.save(skier)).thenReturn(skier);

        Skier savedSkier = skierService.addSkier(skier);
        verify(skierRepository).save(skier);

    }

    @Test
     public void testRetrieveAllSkiers() {
        List<Skier> skiers = new ArrayList<>();
        when(skierRepository.findAll()).thenReturn(skiers);

        List<Skier> retrievedSkiers = skierService.retrieveAllSkiers();
        verify(skierRepository).findAll();

        Assertions.assertEquals(0, retrievedSkiers.size());    }

    @Test
    public void testRemoveSkier() {
    	 // Create test data
        Long numSkier = 1L;

        // Call the method to be tested
        skierService.removeSkier(numSkier);

        // Verify that the deleteById method is called
        verify(skierRepository).deleteById(numSkier);
    }

//    @Test
//    public void testRetrieveInstructor() {
//        Long numInstructor = 1L;
//        Instructor instructor = new Instructor();
//        when(instructorRepository.findById(numInstructor)).thenReturn(Optional.of(instructor));
//
//        Instructor retrievedInstructor = instructorService.retrieveInstructor(numInstructor);
//        verify(instructorRepository).findById(numInstructor);
//
//        // Vous pouvez ajouter des assertions supplémentaires ici en fonction de votre cas d'utilisation
//    }
//
    @Test
     void testassignSkierToSubscription() {
    	// Create test data
        Long numSkier = 1L;
        Long numSubscription = 2L;

        Skier skier = new Skier(); // Create an instance of Skier with appropriate data
        Subscription subscription = new Subscription(); // Create an instance of Subscription with appropriate data

        // Mock the behavior of the repositories when findById is called
        when(skierRepository.findById(numSkier)).thenReturn(java.util.Optional.ofNullable(skier));
        when(subRepository.findById(numSubscription)).thenReturn(java.util.Optional.ofNullable(subscription));

        // Call the method to be tested
        Skier result = skierService.assignSkierToSubscription(numSkier, numSubscription);

        // Verify that the setSubscription method is called and save method is called
        verify(skierRepository).save(skier);
        

    }
}