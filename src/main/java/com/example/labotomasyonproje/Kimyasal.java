package com.example.labotomasyonproje;

public abstract class Kimyasal {
    String ismi;
    String formul;
    double ph;
    String renkkodu;

    public Kimyasal(String ismi, String formul, double ph, String renkkodu) {
        this.ismi = ismi;
        this.formul = formul;
        this.ph = ph;
        this.renkkodu = renkkodu;
    }

    public String getIsmi() {
        return ismi;
    }

    public String getFormul() {
        return formul;
    }

    public double getPh() {
        return ph;
    }

    public String getRenkkodu() {
        return renkkodu;
    }

    abstract String tehlikelimi();
}
