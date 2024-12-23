package com.example.labotomasyonproje;

import java.util.ArrayList;

public class kullanicilar {
    private String username;
    private String name;
    private String surname;
    private String cinsiyet;
    private String password;
    private boolean yetkilimi;

    private static ArrayList<kullanicilar> kullanicilarListe = new ArrayList<>();


    public kullanicilar(String username,String name,String surname ,String cinsiyet, String password, boolean yetkilimi) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.cinsiyet = cinsiyet;
        this.password = password;
        this.yetkilimi = yetkilimi;


        kullanicilarListe.add(this);
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    private String getPassword() {            //şifre getter'i private oldu başkası erişemesin diye
        return password;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }
    public boolean isYetkilimi() {
        return yetkilimi;
    }

    /* public static ArrayList<kullanicilar> getKullanicilarListe() {
            return kullanicilarListe;
        }       */





    public static kullanicilar kullaniciBul(String kullaniciAdi) {
        for (kullanicilar kullanici : kullanicilarListe) {
            if (kullanici.getUsername().equals(kullaniciAdi)) {
                return kullanici;
            }
        }
        return null;
    }





    public static int bilgisorgulama(String username1, String password1) {
        for (kullanicilar kullanici : kullanicilarListe) {
            if (kullanici.getUsername().equals(username1) && kullanici.getPassword().equals(password1)) {
                return 1;            // iki bilgi de doğru ise 1 gönderiyor
            }
            else if (kullanici.getUsername().equals(username1)){    // kullanici adi doğru ise 2 dönderiyor
                return 2;
            }
        }
        return 0;             // böyle bir kullanıcı yoksa 0 gönderiyor
    }
}
