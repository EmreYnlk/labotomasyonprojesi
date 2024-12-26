package com.example.labotomasyonproje;

import java.util.ArrayList;
import java.util.List;

public class phmetre implements Makineler{
    String barkodno;
    int dayaniklilik;

    public static List<Makineler> tumphmetreler = new ArrayList<>();

    public phmetre(String barkodno, int dayaniklilik) {
        this.barkodno = barkodno;
        this.dayaniklilik = dayaniklilik;
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
    public void dayaniklilikharca(int dayaniklilik) {
        this.dayaniklilik = dayaniklilik - 1;
    }


    @Override
    public String toString() {
        return "Barkod: " + barkodno + " (Dayanıklılık: " + dayaniklilik + ")";
    }


}
