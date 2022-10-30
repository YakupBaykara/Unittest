package com.yb.unittest.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class YasamDongusuTest {

	@BeforeAll
	public static void beforeClass() throws Exception{
		System.out.println("Her test sınıfı - öncesi");
	}
	
	@AfterAll
	public static void afterClass() throws Exception{
		System.out.println("Her test sınıfı - sonrası");
	}
 	
	@BeforeEach
	public void setUp() throws Exception{
		System.out.println("Method öncesi çalıştı");
	}
	
	@AfterEach
	public void tearDown() throws Exception{
		System.out.println("Method sonrası çalıştı");
	}
	
	@Test
	public void test1() throws Exception{
		System.out.println("Test1 çalıştı");
	}
	
	@Test
	public void test2() throws Exception{
		System.out.println("Test2 çalıştı");
	}
}
