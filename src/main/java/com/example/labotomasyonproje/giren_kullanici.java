package com.example.labotomasyonproje;

public class giren_kullanici {
    private static giren_kullanici instance;
    private String kullaniciAdi;
    private String isimSoyisim;
    private String cinsiyet;
    private boolean yetkiliMi;

    // Özel constructor (dışarıdan nesne oluşturulamaz)
    private giren_kullanici() {}

    // Tek instance'ı almak için
    public static giren_kullanici getInstance() {
        if (instance == null) {
            instance = new giren_kullanici();
        }
        return instance;
    }

    // Kullanıcı bilgilerini ayarlamak için
    public void setKullaniciBilgileri(String kullaniciAdi, String isimSoyisim,String cinsiyet, boolean yetkiliMi) {
        this.kullaniciAdi = kullaniciAdi;
        this.isimSoyisim = isimSoyisim;
        this.cinsiyet = cinsiyet;
        this.yetkiliMi = yetkiliMi;
    }

    // Getter metodlar
    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public String getIsimSoyisim() {
        return isimSoyisim;
    }

    public boolean isYetkiliMi() {
        return yetkiliMi;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }
}
