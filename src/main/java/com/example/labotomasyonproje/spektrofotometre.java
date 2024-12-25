package com.example.labotomasyonproje;

import java.util.ArrayList;
import java.util.List;

public class spektrofotometre implements Makineler{
    String barkodno ;
    int dayaniklilik ;
    boolean fisebaglimi ;

    public spektrofotometre(String barkodno, int dayaniklilik, boolean fisebaglimi) {
        this.barkodno = barkodno;
        this.dayaniklilik = dayaniklilik;
        this.fisebaglimi = fisebaglimi;
        Makinelisteleme.ekle(this);
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
    public void dayaniklilikharca(int dayaniklilik) {
        this.dayaniklilik = dayaniklilik - 5;
    }
    @Override
    public void makineyikullan() {
        if (kirikmi(this.dayaniklilik)){
            //eğer kırıksa buraya gelicek
        }else {
            //değilse burdan devam




            // en son dayanıklılık harcanacak
            dayaniklilikharca(this.dayaniklilik);
        }

    }
}


