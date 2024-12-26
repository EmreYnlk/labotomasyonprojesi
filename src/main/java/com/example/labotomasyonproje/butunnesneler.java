package com.example.labotomasyonproje;

public class butunnesneler {


    public static void nesneleritanımla(){
        Yetkili kullanici1 = new Yetkili("emre","Emre","Erkek","Yanalak","12345",'L',"Yönetici");
        Yetkili kullanici2 = new Yetkili("emin","Emin","Erkek","Dinç","12345",'M',"Yardımcı");
        Yetkili kullanici3 = new Yetkili("eren","Eren","Erkek","Başali","12345",'M',"Y");
        Kullanicilar kullanici4 = new Kullanicilar("elçin","Elçin","Kadın","Yılmaz","12345",'S');

        spektrofotometre spektrofotometre1 = new spektrofotometre("S0001",100,true);
        spektrofotometre spektrofotometre2 = new spektrofotometre("S0002",50,true);
        spektrofotometre spektrofotometre3 = new spektrofotometre("S0003",5,true);

        phmetre phmetre1 = new phmetre("P0001",100);
        phmetre phmetre2 = new phmetre("P0002",50);
        phmetre phmetre3 = new phmetre("P0003",5);

        Ekipman eldiven1 = new Ekipman("Eldiven",'S',50,50);
        Ekipman eldiven2 = new Ekipman("Eldiven",'M',50,50);
        Ekipman eldiven3 = new Ekipman("Eldiven",'L',50,50);

        Ekipman gozluk1 = new Ekipman("Gözlük",'S',50,50);
        Ekipman gozluk2 = new Ekipman("Gözlük",'M',50,50);
        Ekipman gozluk3 = new Ekipman("Gözlük",'L',1,50);

        Ekipman onluk1 = new Ekipman("Önlük",'S',50,50);
        Ekipman onluk2 = new Ekipman("Önlük",'M',50,50);
        Ekipman onluk3 = new Ekipman("Önlük",'L',50,50);

        Kim_Asit asit1 = new Kim_Asit("Hidroklorik Asit", "HCl", 1.0, "#FF0000");
        Kim_Asit asit2 = new Kim_Asit("Sülfürik Asit", "H₂SO₄", 1.5, "#FF1A1A");
        Kim_Asit asit3 = new Kim_Asit("Nitrik Asit", "HNO₃", 2.0, "#FF3333");
        Kim_Asit asit4 = new Kim_Asit("Fosforik Asit", "H₃PO₄", 2.5, "#FF4D4D");
        Kim_Asit asit5 = new Kim_Asit("Asetik Asit", "CH₃COOH", 3.0, "#FF6666");
        Kim_Asit asit6 = new Kim_Asit("Karbonik Asit", "H₂CO₃", 4.0, "#FF8080");
        Kim_Asit asit7 = new Kim_Asit("Sitrik Asit", "C₆H₈O₇", 5.0, "#FF9999");
        Kim_Asit asit8 = new Kim_Asit("Laktik Asit", "C₃H₆O₃", 5.5, "#FFB3B3");
        Kim_Asit asit9 = new Kim_Asit("Borik Asit", "H₃BO₃", 6.0, "#FFD9D9");
        Kim_Asit asit10 = new Kim_Asit("Malik Asit", "C₄H₆O₅", 6.5, "#FFE5E5");

        Kim_Baz baz1 = new Kim_Baz("Sodyum Hidroksit", "NaOH", 14.0, "#0000FF");
        Kim_Baz baz2 = new Kim_Baz("Potasyum Hidroksit", "KOH", 13.5, "#1A1AFF");
        Kim_Baz baz3 = new Kim_Baz("Kalsiyum Hidroksit", "Ca(OH)₂", 13.0, "#3333FF");
        Kim_Baz baz4 = new Kim_Baz("Magnezyum Hidroksit", "Mg(OH)₂", 12.5, "#4D4DFF");
        Kim_Baz baz5 = new Kim_Baz("Amonyak", "NH₃", 11.5, "#6666FF");
        Kim_Baz baz6 = new Kim_Baz("Sodyum Karbonat", "Na₂CO₃", 11.0, "#8080FF");
        Kim_Baz baz7 = new Kim_Baz("Çamaşır Sodası", "NaHCO₃", 10.5, "#9999FF");
        Kim_Baz baz8 = new Kim_Baz("Trietilamin", "(C₂H₅)₃N", 10.0, "#B3B3FF");
        Kim_Baz baz9 = new Kim_Baz("Sodyum Borat", "Na₂B₄O₇", 9.5, "#CCCCFF");
        Kim_Baz baz10 = new Kim_Baz("Sodyum Silikat", "Na₂SiO₃", 9.0, "#E5E5FF");





    }
}
