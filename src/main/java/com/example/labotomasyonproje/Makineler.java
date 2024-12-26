package com.example.labotomasyonproje;

public interface Makineler {
    void dayaniklilikharca(int dayaniklilik);
    String getBarkodno();
    int getDayaniklilik();

    String getKendiadi();
    default boolean kirikmi(int dayaniklilik) {
        return dayaniklilik <= 0;
    }
}
