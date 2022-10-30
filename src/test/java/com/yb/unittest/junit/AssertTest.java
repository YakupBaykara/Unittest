package com.yb.unittest.junit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class AssertTest {

	@Getter @Setter @AllArgsConstructor
	public static class Dummy{
		private int id;
		
/*		@Override
		public boolean equals(Object obj) {
			return this.id == ((Dummy) obj).getId();
		} */
	}
	
	@Test
	public void testAssertions() throws Exception{
		
		Dummy dummy1 = new Dummy(5);
		Dummy dummy2 = new Dummy(5);
		
//		assertEquals(dummy1, dummy2);	// Equals metoduna göre eşitliğe bakar. Metod yoksa adrese bakar.
//		assertSame(dummy1, dummy2, "dummy1, dummy2' ye eşit olmalı");		// Adreslere göre kontrol eder.
//		assertNull(dummy1);
//		assertNotNull(dummy1);
		assertTrue(dummy1.equals(dummy2));
		
		String[] arr1 = new String[] {"1", "2"};
		String[] arr2 = new String[] {"3", "2"};
		
		assertArrayEquals(arr1, arr2);
 	}
}
