package com.example.labotomasyonproje;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.IOException;

public class A_deneyyapmaKontrol {



    @FXML
    private Button deneyyap_geridon;

    @FXML
    void anaekranageriDon(MouseEvent event) {
            String cinsiyet = giren_kullanici.getInstance().getCinsiyet();
            String isimSoyisim = giren_kullanici.getInstance().getIsimSoyisim();
            boolean yetkilimibu = giren_kullanici.getInstance().isYetkiliMi();
                try {
                    // Yeni kök öğeyi yükle
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("uygulama-anaekran.fxml"));
                    Parent yeniRoot = fxmlLoader.load();

                    // Kontrol nesnesini al ve kullanıcı bilgilerini ayarla
                    A_anaekranKontrol kontrol = fxmlLoader.getController();
                    kontrol.setKullaniciBilgisi(cinsiyet, isimSoyisim, yetkilimibu);

                    // Mevcut sahneyi güncelle
                    Scene mevcutSahne = deneyyap_geridon.getScene();
                    mevcutSahne.setRoot(yeniRoot);

                } catch (IOException e) {
                    e.printStackTrace();
                }

        }


    @FXML
    void birlestir_deneyyap(MouseEvent event) {

    }

    @FXML
    void kendinyap_deneyyap(MouseEvent event) {

    }

    @FXML
    public void phmetre_deneyyap(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("deney1.fxml"));
            Parent yeniRoot = fxmlLoader.load();

            // Kontrolör sınıfını alın
            A_deney1Kontrol kontrol = fxmlLoader.getController();

            //phmetre deneyi ekranındaki sağ ve soldaki listeleri doldur
            kontrol.listeleriEkle(1);

            // Tetikleyici kaynağı Node olarak alın
            Node source = (Node) event.getSource();
            Scene mevcutSahne = source.getScene();
            mevcutSahne.setRoot(yeniRoot);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @FXML
    void spektrofo_deneyyap(MouseEvent event) {

    }

}
