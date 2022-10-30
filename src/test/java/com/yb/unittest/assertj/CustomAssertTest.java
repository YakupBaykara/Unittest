package com.yb.unittest.assertj;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CustomAssertTest {

	public static final String USERNAME = "baris";
	public static final String EMAIL = "b@b.com";
	
	private CustomerRepository customerRepository;
	private NotificationService notificationService;
	private CustomerService customerService;

	@BeforeEach
	public void setUp() throws Exception {
		customerService = new CustomerService();
		customerRepository = Mockito.mock(CustomerRepository.class);
		notificationService = Mockito.mock(NotificationService.class);

		customerService.setCustomerRepository(customerRepository);
		customerService.setNotificationService(notificationService);
	}

	@Test
	public void testCustomAssertJUnit() throws Exception {

		Customer customer = customerService.handleNewCustomer(USERNAME, EMAIL);

		Mockito.verify(customerRepository).save(Mockito.any(Customer.class));
		Mockito.verify(notificationService).sendWelcomeNotification(USERNAME, EMAIL);
		Assert.assertNotNull(customer.getGifts());
		Assert.assertEquals(2, customer.getGifts().size());
		Assert.assertEquals("welcome1", customer.getGifts().get(0).getName());
		Assert.assertEquals("welcome2", customer.getGifts().get(1).getName());
	}

	@Test
	public void testCustomAssert() throws Exception {

		Customer customer = customerService.handleNewCustomer(USERNAME, EMAIL);

		// assertThat gibi kendi metodumuzu yazıyoruz ve oluşturduğumuz sınıfın metodlarını yazıyoruz.
		assertThatCustomer(customer)
			.isSaved()
			.hasReceivedWelcomeNotification()
			.hasGifts(2)
			.hasGiftWithName("welcome1")
			.hasGiftWithName("welcome2");
	}

	private CustomerAssert assertThatCustomer(Customer customer) {
		return new CustomerAssert(customer, CustomerAssert.class, customerRepository, notificationService);
	}
}
