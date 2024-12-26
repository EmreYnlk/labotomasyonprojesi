package com.example.labotomasyonproje;

import java.util.ArrayList;
import java.util.List;

public class Kim_Baz extends Kimyasal{

    public static List<Kim_Baz> bazListesi = new ArrayList<>();

    public Kim_Baz(String ismi, String formul, double ph, String renkkodu) {
        super(ismi, formul, ph, renkkodu);
        bazListesi.add(this);
    }
    @Override
    public String getKendiadi(){
        return "Baz";
    }

    @Override
    String tehlikelimi() {
        return ( (this.ph > 12) ? "Tehlikeli" : "Az tehlikeli" );
    }

    @Override
    public String toString() {
        return ismi + " (" + formul + ")";
    }
}
