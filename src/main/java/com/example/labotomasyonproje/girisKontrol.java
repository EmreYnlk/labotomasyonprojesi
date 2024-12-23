package com.example.labotomasyonproje;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

import static com.example.labotomasyonproje.kullanicilar.bilgisorgulama;

public class girisKontrol {


    kullanicilar kullanici1 = new kullanicilar("Emre","Emre","Yanalak","Erkek","12345",true);
    kullanicilar kullanici2 = new kullanicilar("Emin","Emin","Dinç","Erkek","12345",true);
    kullanicilar kullanici3 = new kullanicilar("Eren","Eren","Başali","Erkek","12345",true);
    kullanicilar Kullanici4 = new kullanicilar("Elçin","Elçin","Yılmaz","Kadın","12345",false);
    kullanicilar kullanici5 = new kullanicilar("Maske","Ahmet","Yılmaz","Erkek","12345",false);

    @FXML
    private TextField kullaniciadi_giris;

    @FXML
    private PasswordField kullanicisifre_giris;

    @FXML
    private void login() {
        String kullaniciAdi = kullaniciadi_giris.getText();
        String sifre = kullanicisifre_giris.getText();

        int sonuc = bilgisorgulama(kullaniciAdi, sifre);
        switch (sonuc) {
            case 1 -> {
                kullanicilar mevcutKullanici = kullanicilar.kullaniciBul(kullaniciAdi);
                goodloginmesaj();
                yeniSahne(mevcutKullanici.getCinsiyet(), mevcutKullanici.getName() + " " + mevcutKullanici.getSurname(), mevcutKullanici.isYetkilimi());
            }
            case 0 -> badloginmesaj(true);
            default -> badloginmesaj(false);
        }
    }




    public void yeniSahne(String cinsiyet, String isimSoyisim,boolean yetkilimi) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("uygulama-anaekran.fxml"));
            Parent root = fxmlLoader.load();

            // Ana ekran kontrolünü al
            anaekranKontrol kontrol = fxmlLoader.getController();
            kontrol.setKullaniciBilgisi(cinsiyet, isimSoyisim,yetkilimi);

            // Yeni sahneyi göster
            Stage stage = new Stage();
            stage.setTitle("Ana Ekran");
            stage.setScene(new Scene(root));
            stage.show();


            Window window = kullaniciadi_giris.getScene().getWindow();
            if (window instanceof Stage) {
                ((Stage) window).close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }







    private void goodloginmesaj() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Giriş Başarılı");
        alert.setHeaderText(null);
        alert.setContentText("Giriş Yapılıyor");
        alert.showAndWait();
    }
    private void badloginmesaj(boolean asd) {
        String hatamesaji;
        if (asd){
            hatamesaji="Böyle Bir Kullanici Bulunmamaktadır";
        }else {
            hatamesaji="Şifreyi Hatalı Girdiniz";
        }
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Giriş Başarısız");
        alert.setHeaderText(null);
        alert.setContentText(hatamesaji);
        alert.showAndWait();
    }
}
