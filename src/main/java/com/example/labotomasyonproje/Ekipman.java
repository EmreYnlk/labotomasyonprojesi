package com.example.labotomasyonproje;

import java.util.ArrayList;
import java.util.List;

public class Ekipman {
    String isim;
    char bedenbuyuklugu;
    int miktar;
    int maksmiktar;
    public static List<Ekipman> ekipmanListesi = new ArrayList<>();

    public Ekipman(String isim, char bedenbuyuklugu, int miktar,int maksmiktar) {
        this.isim = isim;
        this.bedenbuyuklugu = bedenbuyuklugu;
        this.miktar = miktar;
        this.maksmiktar=maksmiktar;
        ekipmanListesi.add(this);
    }

    public String getIsim() {
        return isim;
    }

    public char getBedenbuyuklugu() {
        return bedenbuyuklugu;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public static boolean ekipmankullan_kaldimi(){                           // önce ilk if ile bakıyor 0 dan az olan var mı diye. Yoksa devam edip 1 azaltıyor
        char bununbeden = giren_kullanici.getInstance().getBeden();
        for (Ekipman ekipman : Ekipman.ekipmanListesi) {
            if (ekipman.getBedenbuyuklugu() == bununbeden) {
                if (ekipman.getMiktar() <= 0){
                    return true;
                }
            }
            if (ekipman.getBedenbuyuklugu() == bununbeden) {
                ekipman.setMiktar(ekipman.getMiktar()-1);

            }
        }
        return false;
    }

    @Override
    public String toString() {
        return isim + " ("+bedenbuyuklugu+" beden " + miktar + " adet)";
    }

}
