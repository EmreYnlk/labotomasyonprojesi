package com.example.labotomasyonproje;

import java.util.ArrayList;
import java.util.List;

public class Ekipman {
    String isim;
    String bedenbuyuklugu;
    int miktar;
    public static List<Ekipman> ekipmanListesi = new ArrayList<>();

    public Ekipman(String isim, String bedenbuyuklugu, int miktar) {
        this.isim = isim;
        this.bedenbuyuklugu = bedenbuyuklugu;
        this.miktar = miktar;
        ekipmanListesi.add(this);
    }

    public String getIsim() {
        return isim;
    }

    public String getBedenbuyuklugu() {
        return bedenbuyuklugu;
    }

    public int getMiktar() {
        return miktar;
    }

    public void ekipmankullan(String hangiekipman, String beden){

    }


}
