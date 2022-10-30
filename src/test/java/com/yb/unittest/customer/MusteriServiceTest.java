package com.yb.unittest.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MusteriServiceTest {
	
	private MusteriService musteriService;
	private MusteriRepositoryStub musteriRepository = new MusteriRepositoryStub();
	private BilgilendirmeService bilgilendirmeService;
	
	@BeforeEach
	public void setUp() {
		
		// GIVEN
		musteriService = new MusteriService();
		
//		musteriRepository = new MusteriRepository();   // Mock olarak tanımlandı

/*  	musteriRepository = Mockito.mock(MusteriRepository.class);  // Gerçek Stub nesnesi olarak tanımlandı.
 */
		
//		bilgilendirmeService = new BilgilendirmeService();	// Mock olarak tanımlandı
		bilgilendirmeService = Mockito.mock(BilgilendirmeService.class);
		
		musteriService.setMusteriRepository(musteriRepository);
		musteriService.setBilgilendirmeService(bilgilendirmeService);
	}
	
	@Test
	public void testMusteriKaydet() {
		
		// WHEN
		Musteri musteri = new Musteri(1234);
		musteriService.musteriKaydet(musteri);
		
		// THEN
// 		Mockito.verify(musteriRepository).kaydet(musteri);	// assertTrue kullanılınca gerek kalmadı
//		assertTrue(musteriRepository.getMusteriListesi().containsValue(musteri));	// bul() metodu kullanılacak
		assertEquals(musteri, musteriRepository.bul(musteri.getId()));
		
		Mockito.verify(bilgilendirmeService).yeniKayitMailGonder(musteri);
		musteriRepository.sil(musteri.getId());	// Başka testleri etkilememesi için yapılan değişiklikler silinir.
	}
	
	@Test
	public void testMusteriSil() {
		
//		assertNotNull(musteriRepository.bul(1234));
		
		// Her test için yeni kayıt oluşturulur
		musteriService.musteriKaydet(new Musteri(1234));
        
		musteriService.musteriSil(1234);
		assertNull(musteriRepository.bul(1234));
	}
}
