package com.example.labotomasyonproje;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class A_yoneticiKontrol {
    @FXML
    private ChoiceBox<String> yikamaChoice;

    @FXML
    private Label yikamaLabel;

    @FXML
    private Button yika;

    @FXML
    private Button makineleriListele;

    @FXML
    private Button ana_cikisButonu;

    @FXML
    private ListView<Makineler> makinelerListe;

    @FXML
    private Label tamirLabel;


    @FXML
    private Label alLabel;


    @FXML
    void deneyekraninacik(MouseEvent event) {
        String cinsiyet = giren_kullanici.getInstance().getCinsiyet();
        String isimSoyisim = giren_kullanici.getInstance().getIsimSoyisim();
        boolean yetkilimibu = giren_kullanici.getInstance().isYetkiliMi();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("uygulama-anaekran.fxml"));
            Parent yeniRoot = fxmlLoader.load();

            A_anaekranKontrol kontrol = fxmlLoader.getController();
            kontrol.setKullaniciBilgisi(cinsiyet, isimSoyisim, yetkilimibu);

            // Ana ekrana donus
            Scene mevcutSahne = ana_cikisButonu.getScene();
            mevcutSahne.setRoot(yeniRoot);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void yoneticiMaKineList(ActionEvent event) { yoneticiEkranListele();}
    public void yoneticiEkranListele(){
        makinelerListe.getItems().clear();
        makinelerListe.getItems().addAll(phmetre.tumphmetreler);
        makinelerListe.getItems().addAll(spektrofotometre.tumspektrofometre);
        makinelerListe.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        makineleriListele.setDisable(true);
    }

    @FXML
    public void tamirEt(ActionEvent event) {
        Makineler secim = makinelerListe.getSelectionModel().getSelectedItem();
        if (secim != null) {
            tamirLabel.setText(secim.getKendiadi() + " " + secim.getBarkodno() + " tamir edildi!");
            secim.setDayaniklilik(secim.getMax_dayaniklilik());
            yoneticiEkranListele();
        } else {
            tamirLabel.setText("Lütfen bir makine seçin.");
        }
    }

    public void initialize(){
        ObservableList<String> yikanacakEkipmanlar = FXCollections.observableArrayList();
        for (Ekipman ekipman : Ekipman.ekipmanListesi) {
            if (!ekipman.isim.equals("Eldiven")) {
                yikanacakEkipmanlar.add(ekipman.getIsim() + " (" + ekipman.getBedenbuyuklugu() + ")");
            }
        }
        yikamaChoice.setItems(yikanacakEkipmanlar);
    }


    @FXML
    public void yika(ActionEvent event) {
        String secim = yikamaChoice.getValue();
        if (secim != null) {
            Ekipman gecici = null;
            for (Ekipman ekipman : Ekipman.ekipmanListesi) {
                String ekipmanIsmi = ekipman.getIsim() + " (" + ekipman.getBedenbuyuklugu() + ")";
                if (ekipmanIsmi.equals(secim)) {
                    gecici = ekipman;
                    break;
                }
            }
            if (gecici != null) {
                yikamaLabel.setText(gecici.getIsim() + " (" + gecici.getBedenbuyuklugu() + ")" + " yıkandı!");
                gecici.setMiktar(gecici.getMaksmiktar());
            } else {
                yikamaLabel.setText("Seçilen ekipman bulunamadı.");
            }
        } else {
            yikamaLabel.setText("Lütfen bir ekipman seçin.");
        }
    }

    @FXML
    public void al(ActionEvent event) {
        alLabel.setText("Depolar fullendi!");
        for (Ekipman ekipman : Ekipman.ekipmanListesi) {
            if (ekipman.getIsim().equals("Eldiven")) {
                ekipman.setMiktar(ekipman.getMaksmiktar());
            }
        }
    }
}

