package com.example.labotomasyonproje;

public class Yetkili extends Kullanicilar{
    String yetkisine;

    public Yetkili(String kullaniciadi, String isim, String cinsiyet, String soyisim, String sifre, String yetkisine) {
        super(kullaniciadi, isim, cinsiyet, soyisim, sifre);
        this.yetkisine = yetkisine;
    }

    @Override
    public boolean buyetkilimi(){
        return true;
    }



}
