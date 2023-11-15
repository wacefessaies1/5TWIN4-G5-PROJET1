package tn.esprit.spring.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.entities.TypeSubscription;
import tn.esprit.spring.repositories.ISkierRepository;
import tn.esprit.spring.repositories.ISubscriptionRepository;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SubscriptionServicesImplTest {

    @Mock
    private ISubscriptionRepository subscriptionRepository;

    @Mock
    private ISkierRepository skierRepository;

    @InjectMocks
    private SubscriptionServicesImpl subscriptionService;

    @Test
    public void testRetrieveAllSubscriptions() {

		LocalDate startDate = LocalDate.of(2010, 10, 10);
		LocalDate endDate = LocalDate.of(2011, 11, 11);
		Subscription subscription1 = new Subscription(10L, startDate, endDate, 200.0f, TypeSubscription.MONTHLY);
        Subscription subscription2 = new Subscription(20L, startDate, endDate, 200.0f, TypeSubscription.ANNUAL);
        
        List<Subscription> subscriptions = Arrays.asList(subscription1, subscription2);

        Mockito.when(subscriptionRepository.findAll()).thenReturn(subscriptions);

        // Act
        List<Subscription> result = subscriptionService.retrieveAllSubscriptions();

        // Assert
        assertEquals(subscriptions, result);
        verify(subscriptionRepository, times(1)).findAll();
        System.out.println("Result: " + result);
    }
}