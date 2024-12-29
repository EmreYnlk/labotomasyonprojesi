package com.example.labotomasyonproje;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.IOException;

public class A_ekipmanKontrol {

    @FXML
    private Button devamButton;

    @FXML
    private CheckBox eldivenCheck;

    @FXML
    private CheckBox gozlukCheck;

    @FXML
    private CheckBox onlukCheck;

    void bedenileilgilibilgi(){
        char bununbeden = giren_kullanici.getInstance().getBeden();
        StringBuilder uygunEkipmanlar = new StringBuilder("Senin bedenine uygun ekipmanlar:\n");

        for (Ekipman ekipman : Ekipman.ekipmanListesi) {
            if (ekipman.getBedenbuyuklugu() == bununbeden) {
                uygunEkipmanlar.append("- ").append(ekipman.getIsim()).append(" (").append(bununbeden).append(" bedenden ").append(ekipman.getMiktar()).append(" adet kaldı.)\n");
            }
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Dikkat et");
        alert.setHeaderText("Unutma, her deney için bir adet ekipman harcarsın!");
        alert.setContentText(uygunEkipmanlar.toString());
        alert.showAndWait();
    }

    @FXML
    public void checkEt() {
        Alert alert;
        if (eldivenCheck.isSelected() && gozlukCheck.isSelected() && onlukCheck.isSelected()) {
            bedenileilgilibilgi();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("deneyyapma.fxml"));
                Parent yeniRoot = fxmlLoader.load();

                // Deney yapma kontrol sınıfını al ve gerekli işlemleri yap
                A_deneyyapmaKontrol kontrol = fxmlLoader.getController();
                // Gerekirse kontrol sınıfına veri aktarabilirsiniz.

                Scene yeniSahne = new Scene(yeniRoot, 923, 660);
                Stage mevcutPencere = (Stage) devamButton.getScene().getWindow();
                mevcutPencere.setScene(yeniSahne);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Eksik Giriş");
            alert.setHeaderText(null);
            alert.setContentText("Lutfen tum ekipmanlari giyin!");
            alert.showAndWait();
        }
    }
}
