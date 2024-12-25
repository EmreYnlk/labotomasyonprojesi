package com.example.labotomasyonproje;

public interface Makineler {
    void makineyikullan();
    void dayaniklilikharca(int dayaniklilik);
    String getBarkodno();
    int getDayaniklilik();

    default boolean kirikmi(int dayaniklilik) {
        return dayaniklilik <= 0;
    }

}
