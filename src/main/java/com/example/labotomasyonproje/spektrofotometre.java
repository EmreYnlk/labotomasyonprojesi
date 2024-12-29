package com.example.labotomasyonproje;

import java.util.ArrayList;
import java.util.List;

public class spektrofotometre implements Makineler{
    String barkodno ;
    int dayaniklilik ;
    boolean fisebaglimi ;
    int max_dayaniklilik ;

    public static List<Makineler> tumspektrofometre = new ArrayList<>();

    public spektrofotometre(String barkodno, int dayaniklilik, boolean fisebaglimi, int max_dayaniklilik) {
        this.barkodno = barkodno;
        this.dayaniklilik = dayaniklilik;
        this.fisebaglimi = fisebaglimi;
        this.max_dayaniklilik = max_dayaniklilik;
        Makinelisteleme.ekle(this);
        tumspektrofometre.add(this);
    }
    @Override
    public String getKendiadi(){
        return "Spektrofotometre";
    }


    public boolean isFisebaglimi() {
        return fisebaglimi;
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
        this.dayaniklilik = dayaniklilik - 5;
    }

    @Override
    public String toString() {
        return "Barkod: " + barkodno + " (Dayanıklılık: " + dayaniklilik + ",\nFişe Bağlı: " + (fisebaglimi ? "Evet" : "Hayır") + ")";
    }





}


