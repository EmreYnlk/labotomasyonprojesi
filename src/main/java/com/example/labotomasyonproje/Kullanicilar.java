package com.example.labotomasyonproje;

import java.util.ArrayList;

public class Kullanicilar {
    protected String kullaniciadi;
    protected String isim;
    protected String soyisim;
    protected String cinsiyet;
    protected String sifre;
    protected char beden;
    protected static ArrayList<Kullanicilar> kullanicilarListe = new ArrayList<>();

    public Kullanicilar(String kullaniciadi, String isim, String cinsiyet, String soyisim, String sifre,char beden) {
        this.kullaniciadi = kullaniciadi;
        this.isim = isim;
        this.cinsiyet = cinsiyet;
        this.soyisim = soyisim;
        this.sifre = sifre;
        this.beden=beden;
        kullanicilarListe.add(this);
    }

    private String getSifre() {return sifre;}
    public String getKullaniciadi() {return kullaniciadi;}
    public String getIsim() {return isim;}
    public String getSoyisim() {return soyisim;}
    public String getCinsiyet() {return cinsiyet;}
    public char getBeden(){return beden;}


    public boolean buyetkilimi(){
        return false;
    }

    public static Kullanicilar suankiKullanici(String kullaniciAdi) {
        for (Kullanicilar kullanici : kullanicilarListe) {
            if (kullanici.getKullaniciadi().equals(kullaniciAdi)) {
                return kullanici;
            }
        }
        return null;
    }


    public static int bilgisorgulama(String username, String password) {
        for (Kullanicilar kullanici : kullanicilarListe) {
            if (kullanici.getKullaniciadi().equals(username) && kullanici.getSifre().equals(password)) {
                return 1;            // iki bilgi de doğru ise 1 gönderiyor
            }
            else if (kullanici.getKullaniciadi().equals(username)){    // kullanici adi doğru ise 2 dönderiyor
                return 2;
            }
        }
        return 0;             // böyle bir kullanıcı yoksa 0 gönderiyor
    }
}
