package com.example.labotomasyonproje;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

import static com.example.labotomasyonproje.Kullanicilar.bilgisorgulama;


public class A_girisKontrol {
    @FXML
    private TextField kullaniciadi_giris;
    @FXML
    private Button giris_butonu;
    @FXML
    private PasswordField kullanicisifre_giris;

    public void login() {
        String kullaniciAdi = kullaniciadi_giris.getText();
        String sifre = kullanicisifre_giris.getText();
        int sayac = bilgisorgulama(kullaniciAdi,sifre);
        if (sayac==1){
            goodloginmesaj();
            //Burası çok önemli ----- Burada giren_kullanıcının kim olduğu veriliyor
            Kullanicilar mevcutKullanici = Kullanicilar.suankiKullanici(kullaniciAdi);
            giren_kullanici.getInstance().setKullaniciBilgileri(kullaniciAdi,mevcutKullanici.getIsim() + " " + mevcutKullanici.getSoyisim(),mevcutKullanici.getCinsiyet(), mevcutKullanici.buyetkilimi(),mevcutKullanici.getBeden());
            //Burasi çok önemli

            anaEkran();

        }
        else {
            if (sayac == 2){
                badloginmesaj(true);
            }
            else {
                badloginmesaj(false);
            }
        }
    }




    public void anaEkran() {
        try {
            String cinsiyet = giren_kullanici.getInstance().getCinsiyet();
            String isimSoyisim = giren_kullanici.getInstance().getIsimSoyisim();
            boolean yetkilimibu = giren_kullanici.getInstance().isYetkiliMi();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("uygulama-anaekran.fxml"));
            Parent root = fxmlLoader.load();

            A_anaekranKontrol kontrol = fxmlLoader.getController();
            kontrol.setKullaniciBilgisi(cinsiyet, isimSoyisim,yetkilimibu);

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
    private void badloginmesaj(boolean kullanicivarmi) {
        String hatamesaji;
        if (!kullanicivarmi){
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
