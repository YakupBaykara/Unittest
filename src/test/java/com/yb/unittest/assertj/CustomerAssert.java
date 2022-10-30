package com.yb.unittest.assertj;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractAssert;
import org.mockito.Mockito;

public class CustomerAssert extends AbstractAssert<CustomerAssert, Customer> {

    private CustomerRepository customerRepository;
    private NotificationService notificationService;

    // Constructor
    public CustomerAssert(Customer actual, 
    		Class<?> selfType, 
    		CustomerRepository customerRepository, 
    		NotificationService notificationService) {
    	
        super(actual, selfType);
        this.customerRepository = customerRepository;
        this.notificationService = notificationService;
        isNotNull();
    }
    
    public CustomerAssert isSaved() {
        Mockito.verify(customerRepository).save(Mockito.any(Customer.class));
        return this;
    }

    public CustomerAssert hasReceivedWelcomeNotification() {
        Mockito.verify(notificationService).sendWelcomeNotification(CustomAssertTest.USERNAME, CustomAssertTest.EMAIL);
        return this;
    }

    public CustomerAssert hasGifts(int sizeOfGifts) {
        assertThat(actual.getGifts())
                .isNotEmpty()
                .hasSize(sizeOfGifts);

        return this;
    }

    public CustomerAssert hasGiftWithName(String giftName) {
        assertThat(actual.getGifts())
                .isNotEmpty()
                .extracting("name")
                .contains(giftName);

        return this;
    }
}
