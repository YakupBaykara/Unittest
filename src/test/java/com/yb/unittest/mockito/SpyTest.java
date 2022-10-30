package com.yb.unittest.mockito;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.Test;

public class SpyTest {

    @Test
    public void testSpy() throws Exception {

        // spy nesneler abstract olamaz.
    	DummyCustomerService service = spy(new DummyCustomerServiceImpl());
        
        // istanbul verilirse hiçbir şey yapmaz. Başka bir değerde gerçek nesneyi döner
        doNothing().when(service).addCustomer(eq("istanbul"));  
        service.addCustomer("ankara");
        
//        doThrow(new IllegalArgumentException()).when(service).removeCustomer(anyString());
//        service.removeCustomer("****");
        
        doNothing().when(service).removeCustomer("istanbul1");
        doNothing().when(service).removeCustomer("istanbul2");
//        doCallRealMethod().when(service).removeCustomer("istanbul3");  //default olarak gercek method cagirilir

        service.removeCustomer("istanbul1");
        service.removeCustomer("istanbul2");
        service.removeCustomer("istanbul3");  //ekrana yazilmasi bekleniyor
    }
}
