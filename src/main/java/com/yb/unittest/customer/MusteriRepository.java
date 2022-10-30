package com.yb.unittest.customer;

public class MusteriRepository {

	public void kaydet(Musteri musteri) {
		System.out.println("Müsteri kaydedildi!");
	}
	
	public void sil(Integer musteriId) {
		System.out.println("Müsteri silindi!");
	}
	
	public Musteri bul(Integer musteriId) {
		return null;
	}
}
