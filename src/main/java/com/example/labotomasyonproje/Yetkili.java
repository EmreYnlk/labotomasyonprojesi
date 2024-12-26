package com.example.labotomasyonproje;

public class Yetkili extends Kullanicilar{
    String yetkisine;

    public Yetkili(String kullaniciadi, String isim, String cinsiyet, String soyisim, String sifre,char beden, String yetkisine) {
        super(kullaniciadi, isim, cinsiyet, soyisim, sifre,beden);
        this.yetkisine = yetkisine;
    }

    @Override
    public boolean buyetkilimi(){
        return true;
    }



}
