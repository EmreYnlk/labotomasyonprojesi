package com.example.labotomasyonproje;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class A_deney1Kontrol {
    static int hangideney;

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
        /*phsonucuburda.setVisible(false);
        spektrofotmetredeneyiyazisi1.setVisible(false);*/
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
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Eyvaah!!");
                alert.setHeaderText("Eksik Seçim Yaptınız");
                alert.setContentText("");
                alert.showAndWait();
                return;
            }
            else {solSecim = deney1_solliste.getSelectionModel().getSelectedItem();
                sagSecim = deney1_sagliste.getSelectionModel().getSelectedItem();
            }

            if (sagSecim.kirikmi(sagSecim.getDayaniklilik())){
                //makine kırık işlem yapamaz
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Tüh.Bir şeyler yanlış");
                alert.setHeaderText("Olamaz. Seçtiğiniz Phmetre Kırık Lütfen Başka Bir Phmetre Seçin");
                alert.setContentText("");
                alert.showAndWait();
            } else {
                //makine kırık değil işleme devam
                sagSecim.dayaniklilikharca(sagSecim.getDayaniklilik());
                phsonucuburda.setVisible(true);
                phsonucuburda.setText( solSecim.formul +"'ın ph'ı:"+String.valueOf(solSecim.ph));
                listeleriEkle(1); //liste güncellenmeli
                }
        }
        else if(hangideney==2){           //en geniş if'in 2.si ///////////////////////////////////////////////////////////////////////////////
            Kimyasal solSecim;
            Makineler sagSecim;
            if (deney1_solliste.getSelectionModel().getSelectedItem()==null || deney1_sagliste.getSelectionModel().getSelectedItem()== null)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Eyvaah!!");
                alert.setHeaderText("Eksik Seçim Yaptınız");
                alert.setContentText("");
                alert.showAndWait();
                return;
            }
            else {solSecim = deney1_solliste.getSelectionModel().getSelectedItem();
                sagSecim = deney1_sagliste.getSelectionModel().getSelectedItem();
            }

            if (sagSecim.kirikmi(sagSecim.getDayaniklilik())){
                //makine kırık işlem yapamaz
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Tüh.Bir şeyler yanlış");
                alert.setHeaderText("Olamaz. Seçtiğiniz Spektrofotometre Kırık Lütfen Başka Bir spektrofotometre Seçin");
                alert.setContentText("");
                alert.showAndWait();
            } else {
                //makine kırık değil işleme devam
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
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Eyvaah!!");
                alert.setHeaderText("Eksik Seçim Yaptınız");
                alert.setContentText("");
                alert.showAndWait();
                return;
            }else {
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


    }
    private void yazigoster(){
        if (hangideney==1 || hangideney==2){
            aciklamayukari.setText("Lütfen yanlardan bir adet asit/baz ve kullanmamız için bir adet");

            deney1_sagliste.setVisible(true);
            deney2_sagliste.setVisible(false);

            aciklamayukari.setVisible(true);
            aciklamadegisen.setVisible(true);
            baslikdegisen.setVisible(true);
        } else if (hangideney==3) {
            aciklamayukari.setText("Lütfen birleştirmemiz için birer adet asit ve baz seçiniz");
            baslikdegisen.setText("Asit ve Baz Birleşimi");

            deney1_sagliste.setVisible(false);
            deney2_sagliste.setVisible(true);

            aciklamayukari.setVisible(true);
            aciklamadegisen.setVisible(false);
            baslikdegisen.setVisible(true);
        }
    }

    public void listeleriEkle(int hangideney) {
        if (hangideney==1){
            this.hangideney=hangideney;
            baslikdegisen.setText("Phmetre ile Ph Ölçme");
            aciklamadegisen.setText("phmetre seçiniz ");
            yazigoster();
            deney1_solliste.getItems().clear();
            deney1_sagliste.getItems().clear();

            // Kimyasallar için
            deney1_solliste.getItems().addAll(Kim_Asit.asitListesi); // Nesneleri ekle
            deney1_solliste.getItems().addAll(Kim_Baz.bazListesi); // Nesneleri ekle

            // Makineler için
            deney1_sagliste.getItems().addAll(phmetre.tumphmetreler); // Nesneleri ekle
        }
        else if (hangideney==2){
            this.hangideney=hangideney;
            baslikdegisen.setText("Spektrofotometre ile Renk Değişimi");
            aciklamadegisen.setText("spektrofotometre seçiniz ");
            yazigoster();
            deney1_solliste.getItems().clear();
            deney1_sagliste.getItems().clear();

            // Kimyasallar için
            deney1_solliste.getItems().addAll(Kim_Asit.asitListesi); // Nesneleri ekle
            deney1_solliste.getItems().addAll(Kim_Baz.bazListesi); // Nesneleri ekle

            // Makineler için
            deney1_sagliste.getItems().addAll(spektrofotometre.tumspektrofometre); // Nesneleri ekle

        }
        else if (hangideney==3){
            this.hangideney=hangideney;
            yazigoster();
            deney1_solliste.getItems().clear();
            deney2_sagliste.getItems().clear();

            deney1_solliste.getItems().addAll(Kim_Asit.asitListesi);
            deney2_sagliste.getItems().addAll(Kim_Baz.bazListesi);



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


}
