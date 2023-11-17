package tn.esprit.spring.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

        List<Subscription> result = subscriptionService.retrieveAllSubscriptions();
        assertEquals(subscriptions, result);
        verify(subscriptionRepository, times(1)).findAll();
        System.out.println("Result: " + result);
    }
    
    @Test
    public void testAddSubscription() {

        LocalDate startDate = LocalDate.of(2010, 10, 10);
		LocalDate endDate = LocalDate.of(2011, 11, 11);
		Subscription subscription = new Subscription(50L, startDate, endDate, 200.0f, TypeSubscription.MONTHLY);
        
        
        Mockito.when(subscriptionRepository.save(Mockito.any(Subscription.class))).thenReturn(subscription);

        Subscription savedSubscription = subscriptionService.addSubscription(subscription);
        assertEquals(subscription, savedSubscription);
    }
    
    @Test
    public void testRetrieveSubscriptionById() {
        long subscriptionId = 1L;
        Subscription subscription = new Subscription();
        subscription.setNumSub(subscriptionId);
        Mockito.when(subscriptionRepository.findById(subscriptionId)).thenReturn(Optional.of(subscription));

        Subscription retrievedSubscription = subscriptionService.retrieveSubscriptionById(subscriptionId);
        assertEquals(subscription, retrievedSubscription);
    }
    
    @Test
    public void testRetrieveSubscriptionByType() {

    	TypeSubscription subscriptionType = TypeSubscription.ANNUAL;
        LocalDate startDate = LocalDate.of(2010, 10, 10);
		LocalDate endDate = LocalDate.of(2011, 11, 11);
		Subscription subscription1 = new Subscription(11L, startDate, endDate, 250.0f, subscriptionType);
        Subscription subscription2 = new Subscription(12L, startDate, endDate, 350.0f, subscriptionType);
        
        List<Subscription> subscriptionsList = new ArrayList<>();
        subscriptionsList.add(subscription1);
        subscriptionsList.add(subscription2);

        Mockito.when(subscriptionService.getSubscriptionByType(subscriptionType)).thenReturn(new HashSet<>(subscriptionsList));

        Set<Subscription> retrievedSubscription = subscriptionService.getSubscriptionByType(subscriptionType);
        assertEquals(2, retrievedSubscription.size());
    }
    
}