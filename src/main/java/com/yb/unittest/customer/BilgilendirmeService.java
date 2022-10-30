package com.yb.unittest.customer;

public class BilgilendirmeService {

    public void yeniKayitMailGonder(Musteri musteri) {
        System.out.println("Mail gonderildi");
    }
    
    public void haftalikMailGonder() {
    	throw new MailServerUnavailableException("Mail server hata veriyor");
    }
}
