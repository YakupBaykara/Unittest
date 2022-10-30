package com.yb.unittest.mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class OnAsamaTest {

	@Test
	public void testWhen() throws Exception {
		
		// Mock nesneleri hiç bir şey yapılmazsa null döner

		DummyCustomerService service = mock(DummyCustomerService.class);
//		when(service.getCustomer(anyString())).thenReturn("customerIstanbul"); // ankara parametre veririlirse calisiyor
		when(service.getCustomer(eq("istanbul"))).thenReturn("customerIstanbul"); 																		
		
		String customer = service.getCustomer("istanbul");	// başka bir string ile çağırılırsa null döner
		assertThat(customer).isEqualTo("customerIstanbul");
	}

	@Test
	public void testWhen2() throws Exception {

		DummyCustomerService service = mock(DummyCustomerService.class);
		when(service.getCustomer(eq("istanbul"))).thenThrow(new RuntimeException()); 	// başka bir string verilirse çalışıyor																					 
		service.getCustomer("istanbul");
	}

	@Test
	public void testWhen3() throws Exception {
		
		// when, then metodlarında her zaman bir geri bildirim gerekir.
		// void geri veren methodlar nasil when kullanir?

		DummyCustomerService service = mock(DummyCustomerService.class);

		// tam tersi yazilan do ile baslayan methodlar

		doNothing().when(service).addCustomer(anyString());
		doThrow(new RuntimeException()).when(service).addCustomer(anyString());

		// ayni return when burada yazilabilir
		doReturn("ankara").when(service).getCustomer("istanbul");

	}
}
