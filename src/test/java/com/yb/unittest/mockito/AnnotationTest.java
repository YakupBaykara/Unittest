package com.yb.unittest.mockito;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.yb.unittest.assertj.CustomerRepository;
import com.yb.unittest.assertj.CustomerService;
import com.yb.unittest.assertj.NotificationService;

@RunWith(MockitoJUnitRunner.class)
public class AnnotationTest {

	// Aşağıdaki işlemin kolay hali
    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private NotificationService notificationService;

    @Test
    public void testAnnotation3() throws Exception {
        customerService.handleNewCustomer("name", "email");
    }
    
    
/*	ÖNCEKİ İŞLEM
 * 
   	private CustomerService customerService1;
   	private CustomerRepository customerRepository1;
   	private NotificationService notificationService1;
    	
   	@BeforeEach
   	public void setUp() {
    		
   		// GIVEN
   		customerService1 = new CustomerService();
   		customerRepository1 = Mockito.mock(CustomerRepository.class); 
   		notificationService1 = Mockito.mock(NotificationService.class);
   		
   		customerService1.setCustomerRepository(customerRepository1);
   		customerService1.setNotificationService(notificationService1);
   	}
    	
    @Test
    public void testAnnotation1() throws Exception {
        customerService.handleNewCustomer("name", "email");
    }
*/	

	
/* 1. YOL: Normalde nesne hazırlama
 * 
	private DummyCustomerService dummyCustomerService;
	
	@BeforeEach
	public void setUp() throws Exception {
		dummyCustomerService = mock(DummyCustomerService.class);
	}
	
	@Test
	public void testAnnotation2() throws Exception {
		dummyCustomerService.addCustomer("istanbul");
	}
*/
	
/* 2. YOL: @Mock annotasyonu ile setUp() metdouna gerek kalmadı. @RunWith sınıfa eklenmeli
	
	@Mock
	private DummyCustomerService dummyCustomerService;
	
	@Test
	public void testAnnotation1() throws Exception {
		dummyCustomerService.addCustomer("istanbul");
	}
*/
	
/* 2. YOL: @Spy annotasyonu ile setUp() metdouna gerek olmadan nesne üretilir.
 * Spy nesneler abstract class tan olmaz!
	
	@Spy
	private DummyCustomerService dummyCustomerService;
	
	@Test
	public void testAnnotation3() throws Exception {
		dummyCustomerService.addCustomer("istanbul");
	}
*/
}
