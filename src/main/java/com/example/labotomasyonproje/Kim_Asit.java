package com.example.labotomasyonproje;

import java.util.ArrayList;
import java.util.List;

public class Kim_Asit extends Kimyasal{

    public static List<Kim_Asit> asitListesi = new ArrayList<>();

    public Kim_Asit(String ismi, String formul, double ph, String renkkodu) {
        super(ismi, formul, ph, renkkodu);
        asitListesi.add(this);
    }





    @Override
    String tehlikelimi() {
        return ( (this.ph < 2) ? "Tehlikeli" : "Az tehlikeli" );
    }


    @Override
    public String toString() {
        return ismi + " (" + formul + ")";
    }
}
