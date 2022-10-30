package com.yb.unittest.customer;

import java.util.HashMap;
import java.util.Map;

public class MusteriRepositoryStub extends MusteriRepository{

	private Map<Integer, Musteri> musteriListesi = new HashMap<>();

/*	bul() metodu ile gerek kalmadı
	public Map<Integer, Musteri> getMusteriListesi() {
		return musteriListesi;
	} */
	
	@Override
	public void kaydet(Musteri musteri) {
		musteriListesi.put(musteri.getId(), musteri);
	}

	@Override
	public void sil(Integer musteriId) {
		musteriListesi.remove(musteriId);
	}

	@Override
	public Musteri bul(Integer musteriId) {
		return musteriListesi.get(musteriId);
	}

	
}
