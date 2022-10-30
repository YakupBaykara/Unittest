package com.yb.unittest.customer;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class ExceptionTest {

	private BilgilendirmeService bilgilendirmeService = new BilgilendirmeService();

	@Test
	public void testTryCatchException() {
		try {
			bilgilendirmeService.haftalikMailGonder();
		} catch (Exception e) {
			assertTrue(e instanceof MailServerUnavailableException);
			assertEquals("Mail server hata veriyor", e.getMessage());
		}
	}

	@Test // (expected = MailServerUnavailableException.class)
	public void testExpectedException() throws Exception {
		bilgilendirmeService.haftalikMailGonder();
	}

	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testRuleException() throws Exception {
		thrown.expect(MailServerUnavailableException.class);
		thrown.expectMessage("Mail server hata veriyor");

		bilgilendirmeService.haftalikMailGonder();
	}
	
    @Test
    public void testCatchExceptionFramework() throws Exception {

/*
        catchException(bilgilendirmeService).haftalikMailGonder();
        assertTrue(caughtException() instanceof MailServerUnavailableException);
        assertEquals("Mail server hata veriyor", caughtException().getMessage());
*/
    }
}
