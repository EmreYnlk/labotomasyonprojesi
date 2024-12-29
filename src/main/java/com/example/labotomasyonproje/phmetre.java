package com.example.labotomasyonproje;

import java.util.ArrayList;
import java.util.List;

public class phmetre implements Makineler{
    String barkodno;
    int dayaniklilik;
    int max_dayaniklilik;

    public static List<Makineler> tumphmetreler = new ArrayList<>();

    public phmetre(String barkodno, int dayaniklilik, int max_dayaniklilik) {
        this.barkodno = barkodno;
        this.dayaniklilik = dayaniklilik;
        this.max_dayaniklilik = max_dayaniklilik;
        Makinelisteleme.ekle(this);
        tumphmetreler.add(this);
    }
    @Override
    public String getKendiadi(){
        return "Phmetre";
    }

    @Override
    public String getBarkodno() {
        return barkodno;
    }
    @Override
    public int getDayaniklilik() {
        return dayaniklilik;
    }

    @Override
    public void setDayaniklilik(int dayanik) { this.dayaniklilik=dayanik; }

    @Override
    public int getMax_dayaniklilik() { return max_dayaniklilik; }

    @Override
    public void dayaniklilikharca(int dayaniklilik) {
        this.dayaniklilik = dayaniklilik - 1;
    }

    @Override
    public String toString() {
        return "Barkod: " + barkodno + " (Dayanıklılık: " + dayaniklilik + ")";
    }

    //overload
    public String toString(boolean detayli) {
        if (!detayli)
            return toString();
        else
            return "Phmetre:\n    Barkod: " + barkodno + " (Dayanıklılık: " + dayaniklilik + ")";
    }

}
