package tn.esprit.spring.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Skier;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.entities.TypeSubscription;
import tn.esprit.spring.repositories.ISkierRepository;
import tn.esprit.spring.repositories.ISubscriptionRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@Service
public class SubscriptionServicesImpl implements ISubscriptionServices{

	@Autowired
    private ISubscriptionRepository subscriptionRepository;

	@Autowired
    private ISkierRepository skierRepository;
    
    private static final Logger log = LoggerFactory.getLogger(SubscriptionServicesImpl.class);

    @Override
    public Subscription addSubscription(Subscription subscription) {
        switch (subscription.getTypeSub()) {
            case ANNUAL:
                subscription.setEndDate(subscription.getStartDate().plusYears(1));
                break;
            case SEMESTRIEL:
                subscription.setEndDate(subscription.getStartDate().plusMonths(6));
                break;
            case MONTHLY:
                subscription.setEndDate(subscription.getStartDate().plusMonths(1));
                break;
        }
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription retrieveSubscriptionById(Long numSubscription) {
        return subscriptionRepository.findById(numSubscription).orElse(null);
    }

    @Override
    public Set<Subscription> getSubscriptionByType(TypeSubscription type) {
        return subscriptionRepository.findByTypeSubOrderByStartDateAsc(type);
    }

    @Override
    public List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        return subscriptionRepository.getSubscriptionsByStartDateBetween(startDate, endDate);
    }

	@Override
	public void retrieveSubscriptions() {
		// TODO Auto-generated method stub
		
	}

    //@Override
    //@Scheduled(cron = "*/30 * * * * *") /* Cron expression to run a job every 30 secondes */
    /*public void retrieveSubscriptions() {
        for (Subscription sub: subscriptionRepository.findDistinctOrderByEndDateAsc()) {
            Skier   aSkier = skierRepository.findBySubscription(sub);
            log.info(sub.getNumSub().toString() + " | "+ sub.getEndDate().toString()
                    + " | "+ aSkier.getFirstName() + " " + aSkier.getLastName());
        }
    }*/

   // @Scheduled(cron = "* 0 9 1 * *") /* Cron expression to run a job every month at 9am */
    /* Cron expression to run a job every 30 secondes */
    //@Scheduled(cron = "*/30 * * * * *")
    /*public void showMonthlyRecurringRevenue() {
        Float revenue = subscriptionRepository.recurringRevenueByTypeSubEquals(TypeSubscription.MONTHLY)
                + subscriptionRepository.recurringRevenueByTypeSubEquals(TypeSubscription.SEMESTRIEL)/6
                + subscriptionRepository.recurringRevenueByTypeSubEquals(TypeSubscription.ANNUAL)/12;
        log.info("Monthly Revenue = " + revenue);
    }*/
}
