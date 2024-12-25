package com.example.labotomasyonproje;

import java.util.ArrayList;
import java.util.List;

public class Makinelisteleme {


    private static final List<Makineler> tumMakineler = new ArrayList<>();

    public static void ekle(Makineler makine) {
        tumMakineler.add(makine);
    }

    public static List<Makineler> tumMakineleriGetir() {
        return tumMakineler;
    }

}
