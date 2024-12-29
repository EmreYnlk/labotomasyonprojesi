package com.example.labotomasyonproje;

public interface Makineler {
    void dayaniklilikharca(int dayaniklilik);
    String getBarkodno();
    int getDayaniklilik();
    void setDayaniklilik(int dayanik);
    int getMax_dayaniklilik();

    String getKendiadi();
    default boolean kirikmi(int dayaniklilik) {
        return dayaniklilik <= 0;
    }

    String toString();
    String toString(boolean detayli);
}
