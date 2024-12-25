package com.example.labotomasyonproje;

import java.util.ArrayList;
import java.util.List;

public class phmetre implements Makineler{
    String barkodno;
    int dayaniklilik;


    public phmetre(String barkodno, int dayaniklilik) {
        this.barkodno = barkodno;
        this.dayaniklilik = dayaniklilik;
        Makinelisteleme.ekle(this);
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
