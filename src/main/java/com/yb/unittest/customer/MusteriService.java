package com.yb.unittest.customer;

public class MusteriService {

	private MusteriRepository musteriRepository;
	private BilgilendirmeService bilgilendirmeService;

	public void setBilgilendirmeService(BilgilendirmeService bilgilendirmeService) {
		this.bilgilendirmeService = bilgilendirmeService;
	}

	public void setMusteriRepository(MusteriRepository musteriRepository) {
		this.musteriRepository = musteriRepository;
	}

	public void musteriKaydet(Musteri musteri) {
		musteriRepository.kaydet(musteri);
		bilgilendirmeService.yeniKayitMailGonder(musteri);
	}
	
    public void musteriSil(Integer musteriId) {
        musteriRepository.sil(musteriId);
    }
}
