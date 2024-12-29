package com.example.labotomasyonproje;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class A_deney1Kontrol {
    static int hangideney;
    static char beden;

    @FXML
    public ListView<Makineler> deney1_sagliste;
    @FXML
    private Label aciklamadegisen;
    @FXML
    private Label aciklamayukari;
    @FXML
    private Label baslikdegisen;
    @FXML
    private Label spektrofotmetredeneyiyazisi1;
    @FXML
    private StackPane degisecekrenkbu;

    @FXML
    private Label phsonucuburda;
    @FXML
    private ListView<Kimyasal> deney1_solliste;
    @FXML
    private ListView<Kimyasal> deney2_sagliste;

    @FXML
    private Button phmetredeney_baslabuton;

    @FXML
    void deneyekraninacik(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("deneyyapma.fxml"));
            Parent yeniRoot = fxmlLoader.load();

            // Deney yapma kontrol sınıfını al ve gerekli işlemleri yap
            A_deneyyapmaKontrol kontrol = fxmlLoader.getController();
            // Gerekirse kontrol sınıfına veri aktarabilirsiniz.

            Scene mevcutSahne = phmetredeney_baslabuton.getScene();
            mevcutSahne.setRoot(yeniRoot);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void deney1Basla(MouseEvent event) {
        if (hangideney==1){
            Kimyasal solSecim;
            Makineler sagSecim;
            if (deney1_solliste.getSelectionModel().getSelectedItem()==null || deney1_sagliste.getSelectionModel().getSelectedItem()== null)
            {
                uyarilarfonksiyonu(4);
                return;
            }
            else {solSecim = deney1_solliste.getSelectionModel().getSelectedItem();
                sagSecim = deney1_sagliste.getSelectionModel().getSelectedItem();
            }

            if (sagSecim.kirikmi(sagSecim.getDayaniklilik())){
                //makine kırık işlem yapamaz
                uyarilarfonksiyonu(5);
            } else {
                //makine kırık değil işleme devam
                if (ekipmanikullan_kirikmi()){
                    uyarilarfonksiyonu(1);
                    return;
                }
                ///////////////////////
                sagSecim.dayaniklilikharca(sagSecim.getDayaniklilik());
                phsonucuburda.setVisible(true);
                phsonucuburda.setText( solSecim.formul +"'ın ph'ı:"+String.valueOf(solSecim.ph)+"("+solSecim.tehlikelimi()+")");
                listeleriEkle(1); //liste güncellenmeli
                }
        }
        else if(hangideney==2){           //en geniş if'in 2.si ///////////////////////////////////////////////////////////////////////////////
            Kimyasal solSecim;
            Makineler sagSecim;
            if (deney1_solliste.getSelectionModel().getSelectedItem()==null || deney1_sagliste.getSelectionModel().getSelectedItem()== null)
            {
                uyarilarfonksiyonu(4);
                return;
            }
            else {solSecim = deney1_solliste.getSelectionModel().getSelectedItem();
                sagSecim = deney1_sagliste.getSelectionModel().getSelectedItem();
            }

            if (sagSecim.kirikmi(sagSecim.getDayaniklilik())){
                //makine kırık işlem yapamaz
                uyarilarfonksiyonu(3);
            } else {
                //makine kırık değil işleme devam
                spektrofotometre gecici_spektro = (spektrofotometre) sagSecim; // Tür dönüştürme
                if (!gecici_spektro.isFisebaglimi()) {
                    uyarilarfonksiyonu(2);
                    return;}
                else if (ekipmanikullan_kirikmi()){                  // burda birbirine bağlı olmazsa ilk hatadan geçip diğerinde kaldığı durumlarda
                    uyarilarfonksiyonu(1);                // ilk işlemi gerçekleştiriyordu.
                    return;
                }
                ///////////////////////
                sagSecim.dayaniklilikharca(sagSecim.getDayaniklilik());
                spektrofotmetredeneyiyazisi1.setVisible(true);
                spektrofotmetredeneyiyazisi1.setText( solSecim.formul +" ve indikatör yardımı ile deney yapıldı.Oluşan renk:");
                degisecekrenkbu.setStyle("-fx-background-color: " + solSecim.getRenkkodu() + ";");
                degisecekrenkbu.setVisible(true);
                listeleriEkle(2); //liste güncellenmeli
            }

        } else if(hangideney==3){                               //en geniş if'in 3.sü ///////////////////////////////////////////////////////////////////////////////
            //3. deney tuşa basınca bu çalışacak
            Kimyasal solSecim,sagSecim;
            if (deney1_solliste.getSelectionModel().getSelectedItem()==null || deney2_sagliste.getSelectionModel().getSelectedItem()== null)
            {
                uyarilarfonksiyonu(4);
                return;
            }else {
                if (ekipmanikullan_kirikmi()){
                    uyarilarfonksiyonu(1);
                    return;
                }
                ///////////////////////
                solSecim = deney1_solliste.getSelectionModel().getSelectedItem();
                sagSecim = deney2_sagliste.getSelectionModel().getSelectedItem();
                String ortarenkbu = deney3icinortarenk(sagSecim.getRenkkodu(), solSecim.getRenkkodu());
                degisecekrenkbu.setStyle("-fx-background-color: " + ortarenkbu + ";");
                degisecekrenkbu.setVisible(true);
                double ortaphbu = ( sagSecim.getPh()+ solSecim.getPh() )/2 ;
                phsonucuburda.setText(String.valueOf(ortaphbu));
                phsonucuburda.setVisible(true);
                spektrofotmetredeneyiyazisi1.setText("İki Kimyasal birleşim sonucu renk ve ph =");
                spektrofotmetredeneyiyazisi1.setVisible(true);
            }

        }
        else if(hangideney==4){                               //en geniş if'in 4.sü ///////////////////////////////////////////////////////////////////////////////
            ////4. deney tuşa basınca bu çalışacak
            ObservableList<Kimyasal> solSecim = deney1_solliste.getSelectionModel().getSelectedItems();
            ObservableList<Makineler> sagSecim = deney1_sagliste.getSelectionModel().getSelectedItems();
            if (solSecim.isEmpty()||sagSecim.isEmpty()) {
                uyarilarfonksiyonu(4);
                return;
            } else {
                if (ekipmanikullan_kirikmi()){
                    uyarilarfonksiyonu(1);
                    return;
                }
            }







                    //////////// burdaki hata her nesne için teker teker bakıyor ve teker teker dayanıklılık harcıyor
            for (Makineler makine : sagSecim) {
                // Makine kırık mı
                if (makine.kirikmi(makine.getDayaniklilik())) {
                    uyarilarfonksiyonu(3); // Makine kırık
                    return;
                }
                if (makine instanceof spektrofotometre) {
                    spektrofotometre gecici1_spektro = (spektrofotometre) makine;

                    // Fişe takılı mı kontrolü
                    if (!gecici1_spektro.isFisebaglimi()) {
                        uyarilarfonksiyonu(2); // Fişe takılı değil
                        return;
                    }

                }
            }
            for (Makineler makine : sagSecim) {
                makine.dayaniklilikharca(makine.getDayaniklilik());
            }








            spektrofotmetredeneyiyazisi1.setText("Tebrikler.Her şeyi kendin başardın.");
            spektrofotmetredeneyiyazisi1.setVisible(true);

            ObservableList<String> hepsi = javafx.collections.FXCollections.observableArrayList();
            for (Makineler makine : sagSecim) {
                hepsi.add(makine.getKendiadi()+": " + makine.getBarkodno());
            } hepsi.add("\n");
            for (Kimyasal kimyasal : solSecim) {
                hepsi.add(kimyasal.getKendiadi()+": " + kimyasal.getFormul());
            }

            String icerik = String.join(" ", hepsi);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Tebrikler");
            alert.setHeaderText("Bir deneyin daha sonuna geldik. Tebrik ederiz!");
            alert.setContentText("İşte kullandıkların\n"+icerik);
            alert.showAndWait();
            listeleriEkle(4);

        }
    }
    private void yazigoster(){
        if (hangideney==1){
            baslikdegisen.setText("Phmetre ile Ph Ölçme");
            baslikdegisen.setVisible(true);
            aciklamayukari.setText("Lütfen yanlardan bir adet asit/baz ve kullanmamız için bir adet");
            aciklamayukari.setVisible(true);
            aciklamadegisen.setText("phmetre seçiniz ");
            aciklamadegisen.setVisible(true);

            deney1_sagliste.setVisible(true);          // deney1 sağdaki liste olarak makineleri kullanıyor
            deney2_sagliste.setVisible(false);

        } else if (hangideney==2) {
            baslikdegisen.setText("Spektrofotometre ile Renk Değişimi");
            baslikdegisen.setVisible(true);
            aciklamayukari.setText("Lütfen yanlardan bir adet asit/baz ve kullanmamız için bir adet");
            aciklamayukari.setVisible(true);
            aciklamadegisen.setText("spektrofotometre seçiniz ");
            aciklamadegisen.setVisible(true);

            deney1_sagliste.setVisible(true);          // deney2 sağdaki liste olarak makineleri kullanıyor
            deney2_sagliste.setVisible(false);

        } else if (hangideney==3) {
            baslikdegisen.setText("Asit ve Baz Birleşimi");
            baslikdegisen.setVisible(true);
            aciklamayukari.setText("Lütfen birleştirmemiz için birer adet asit ve baz seçiniz");
            aciklamayukari.setVisible(true);
            //başka bir satıra gerek kalmadı burdaki metin gereksiz olduğu için görünmez yapıyoruz
            aciklamadegisen.setVisible(false);

            deney1_sagliste.setVisible(false);         // deney3 sağdaki liste olarak kimyasalları kullanıyor.
            deney2_sagliste.setVisible(true);

        } else if (hangideney==4) {
            baslikdegisen.setText("Kendin Yap");
            baslikdegisen.setVisible(true);
            aciklamayukari.setText("Lütfen deneyinizde kullanılacakları seçin(Birden fazla seçilebilir)");
            aciklamayukari.setVisible(true);
            //başka bir satıra gerek kalmadı burdaki metin gereksiz olduğu için görünmez yapıyoruz
            aciklamadegisen.setVisible(false);

            deney1_sagliste.setVisible(true);          // deney4 sağdaki liste olarak makineleri kullanıyor
            deney2_sagliste.setVisible(false);

        }

    }

    public void listeleriEkle(int hangideney) {
        this.beden=giren_kullanici.getInstance().getBeden();
        if (hangideney==1){
            this.hangideney=hangideney;

            yazigoster();
            deney1_solliste.getItems().clear();
            deney1_sagliste.getItems().clear();

            // Kimyasallar için
            deney1_solliste.getItems().addAll(Kim_Asit.asitListesi);
            deney1_solliste.getItems().addAll(Kim_Baz.bazListesi);
            deney1_solliste.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);          //tekli seçim istiyoruz
            // Phmetre için
            deney1_sagliste.getItems().addAll(phmetre.tumphmetreler);
            deney1_sagliste.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);          // tekli seçim istiyoruz
        }
        else if (hangideney==2){
            this.hangideney=hangideney;
            yazigoster();
            deney1_solliste.getItems().clear();
            deney1_sagliste.getItems().clear();

            // Kimyasallar için
            deney1_solliste.getItems().addAll(Kim_Asit.asitListesi);
            deney1_solliste.getItems().addAll(Kim_Baz.bazListesi);
            deney1_solliste.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);                  // tekli seçim istiyoruz

            // Spektrofotometre için
            deney1_sagliste.getItems().addAll(spektrofotometre.tumspektrofometre);
            deney1_sagliste.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);                     // tekli seçim istiyoruz
        }
        else if (hangideney==3){
            this.hangideney=hangideney;
            yazigoster();
            deney1_solliste.getItems().clear();
            deney2_sagliste.getItems().clear();

            // Asit için
            deney1_solliste.getItems().addAll(Kim_Asit.asitListesi);
            deney1_solliste.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);              // tekli seçim istiyoruz
            //Baz için
            deney2_sagliste.getItems().addAll(Kim_Baz.bazListesi);
            deney2_sagliste.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);            // tekli seçim istiyoruz


        } else if (hangideney==4) {
            this.hangideney=hangideney;
            yazigoster();
            deney1_solliste.getItems().clear();
            deney1_sagliste.getItems().clear();

            // Kimyasallar için
            deney1_solliste.getItems().addAll(Kim_Asit.asitListesi);
            deney1_solliste.getItems().addAll(Kim_Baz.bazListesi);
            deney1_solliste.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);          //deney 4 için çoklu seçim istiyoruz
            // Phmetre için
            deney1_sagliste.getItems().addAll(phmetre.tumphmetreler);
            deney1_sagliste.getItems().addAll(spektrofotometre.tumspektrofometre);
            deney1_sagliste.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);          //deney 4 için çoklu seçim istiyoruz

        }




    }


    private String deney3icinortarenk(String renk1,String renk2){
        int r1 = Integer.parseInt(renk1.substring(1, 3), 16);
        int g1 = Integer.parseInt(renk1.substring(3, 5), 16);
        int b1 = Integer.parseInt(renk1.substring(5, 7), 16);

        int r2 = Integer.parseInt(renk2.substring(1, 3), 16);
        int g2 = Integer.parseInt(renk2.substring(3, 5), 16);
        int b2 = Integer.parseInt(renk2.substring(5, 7), 16);

        int ortared = (r1+r2)/2;
        int ortagreen = (g1+g2)/2;
        int ortablue = (b1+b2)/2;
        String sonrgbdeger = String.format("#%02X%02X%02X", ortared, ortagreen, ortablue);
        return sonrgbdeger;
    }


    private boolean ekipmanikullan_kirikmi(){
        return Ekipman.ekipmankullan_kaldimi();
    }

    private void uyarilarfonksiyonu(int hangislem){
        if (hangislem==1){

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Eyvah! Napıcaz");
            alert.setHeaderText("Malesef sana uygun ekipman kalmadı.");
            alert.setContentText("Yöneticilere başvurunuz.");
            alert.showAndWait();
        } else if (hangislem==2) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Eyvah! Napıcaz");
            alert.setHeaderText("Seçtiğin Spektrofotometre Fişe Takılı Değil");
            alert.setContentText("Lütfen Başka Bir Spektrofotometre seç.");
            alert.showAndWait();
        }
        else if (hangislem==3) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Tüh.Bir şeyler yanlış");
            alert.setHeaderText("Olamaz. Seçtiğiniz Spektrofotometre Kırık Lütfen Başka Bir spektrofotometre Seçin");
            alert.setContentText("");
            alert.showAndWait();
        } else if (hangislem==4) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Eyvaah!!");
            alert.setHeaderText("Eksik Seçim Yaptınız");
            alert.setContentText("");
            alert.showAndWait();
        } else if (hangislem==5) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Tüh.Bir şeyler yanlış");
            alert.setHeaderText("Olamaz. Seçtiğiniz Phmetre Kırık Lütfen Başka Bir Phmetre Seçin");
            alert.setContentText("");
            alert.showAndWait();

        }

    }

}
