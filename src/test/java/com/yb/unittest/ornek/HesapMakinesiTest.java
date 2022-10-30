package com.yb.unittest.ornek;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HesapMakinesiTest {

	@Test
	public void testTopla() {

		// GIVEN - Ön Hazırlık
		HesapMakinesi hesapMakinesi = new HesapMakinesi();
		int sayi1 = 5;
		int sayi2 = 19;

		// WHEN - Metodu Çalıştır
		int toplam = hesapMakinesi.topla(sayi1, sayi2);

		// THEN - Sonucu Kontrol Et
		assertEquals(24, toplam);
	}

	@Test
	public void testCikart() throws Exception {

		HesapMakinesi hesapMakinesi = new HesapMakinesi();

		assertEquals(15, hesapMakinesi.cikart(15, 0));
	}

	@Test
	public void testSifirdanCikincaEksiOlur() throws Exception {

		HesapMakinesi hesapMakinesi = new HesapMakinesi();

		assertEquals(-15, hesapMakinesi.cikart(0, 15));
	}

	@Test
	public void testSayidanSifirCikincaAyniSayiKalir() throws Exception {

		HesapMakinesi hesapMakinesi = new HesapMakinesi();

		assertEquals(15, hesapMakinesi.cikart(15, 0));
	}
}
