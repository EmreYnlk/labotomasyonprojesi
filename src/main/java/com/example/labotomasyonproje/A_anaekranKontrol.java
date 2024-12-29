package com.example.labotomasyonproje;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Optional;

public class A_anaekranKontrol {

    @FXML
    private Label hosgeldinMesaji;
    @FXML
    private Label listemesaj;
    @FXML
    private ListView<String> sagdakiliste;
    @FXML
    private ListView<String> soldaki_liste;
    @FXML
    private ImageView profilResmi;
    @FXML
    private ImageView anaekran_gorselpencere;
    @FXML
    private ImageView anaekran_yonetimresmi;
    @FXML
    private Button yonetimButonu;
    @FXML
    private Button deneyYapButon;

    @FXML
    private void anaEkranCik(MouseEvent event) {
        ButtonType evetButonu = new ButtonType("Evet", ButtonBar.ButtonData.OK_DONE);
        ButtonType hayirButonu = new ButtonType("Hayır", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Çıkış Onayı");
        alert.setHeaderText("Uygulamadan çıkmak istiyor musunuz?");
        alert.getButtonTypes().setAll(evetButonu, hayirButonu);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == evetButonu) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("giris-ekrani.fxml"));
                Parent root = fxmlLoader.load();

                Window window = ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                if (window instanceof Stage) {
                    ((Stage) window).close();
                }

                Stage stage = new Stage();
                stage.setTitle("Giriş Ekranı");
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setKullaniciBilgisi(String cinsiyet, String isimSoyisim, boolean yetkilimi) {
        hosgeldinMesaji.setText("Hoşgeldin, " + isimSoyisim);
        yonetimButonu.setVisible(yetkilimi);
        anaekran_yonetimresmi.setVisible(yetkilimi);
        String resimYolu;
        String resimYoluCinsiyet;
        if ("Erkek".equalsIgnoreCase(cinsiyet)) {
            resimYolu = "/resimler/anaekran-erkeksilüet.png";
            resimYoluCinsiyet = "/resimler/anaekran-Egörsel.png";
        } else {
            resimYolu = "/resimler/anaekran-kadınsilüet.png";
            resimYoluCinsiyet = "/resimler/anaekran-Kgörsel.png";
        }
        Image profilResim = new Image(getClass().getResourceAsStream(resimYolu));
        profilResmi.setImage(profilResim);
        profilResmi.setVisible(true);
        Image anaekran_gorselpenceresi = new Image(getClass().getResourceAsStream(resimYoluCinsiyet));
        anaekran_gorselpencere.setImage(anaekran_gorselpenceresi);
        anaekran_gorselpencere.setVisible(true);
    }


    private void tus_ile_gorseldegistir(int sayac) {                //listeleme yapanlar 1 diğerleri 2 gönderiyor
        boolean listeler;
        listeler = (sayac == 1);
        anaekran_gorselpencere.setVisible(false);
        listemesaj.setVisible(listeler);
        soldaki_liste.setVisible(listeler);
        sagdakiliste.setVisible(listeler);

    }

    public void malzemeListele() {
        sagdakiliste.getItems().clear();
        soldaki_liste.getItems().clear();
        listemesaj.setText("Asit ve Bazlar");
        soldaki_liste.setStyle("-fx-font-size: 20px;");
        sagdakiliste.setStyle("-fx-font-size: 20px;");

        for (Kim_Asit asit : Kim_Asit.asitListesi) {
            soldaki_liste.getItems().add(asit.toString());
        }
        for (Kim_Baz baz : Kim_Baz.bazListesi) {
            sagdakiliste.getItems().add(baz.toString());
        }

        tus_ile_gorseldegistir(1);
    }

    public void EkipmanListele() {
        soldaki_liste.getItems().clear();
        sagdakiliste.getItems().clear();
        soldaki_liste.setStyle("-fx-font-size: 14px;");
        sagdakiliste.setStyle("-fx-font-size: 14px;");
        listemesaj.setText("Makine ve Ekipmanlar");
        for (Ekipman ekipman : Ekipman.ekipmanListesi) {
            sagdakiliste.getItems().add(ekipman.toString());
        }
        for (Makineler makine : Makinelisteleme.tumMakineleriGetir()) {
            soldaki_liste.getItems().add(makine.toString(true));

        }
        tus_ile_gorseldegistir(1);
    }

    public void DeneyYap(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("malzemeList.fxml"));
            Parent deneyRoot = fxmlLoader.load();
            Scene mevcutSahne = ((Button) event.getSource()).getScene();

            mevcutSahne.setRoot(deneyRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void YonetimYap() {
        tus_ile_gorseldegistir(2);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("yonetici.fxml"));
            Parent yoneticiRoot = fxmlLoader.load();
            Stage stage = (Stage) yonetimButonu.getScene().getWindow();
            Scene scene = new Scene(yoneticiRoot);
            stage.setScene(scene);
            stage.setTitle("Yonetim");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
