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

import java.io.IOException;

public class A_deney1Kontrol {

    @FXML
    public ListView<Makineler> deney1_sagliste;
    @FXML
    private Label sectiginkimyasal_yazisi;
    @FXML
    private Label phsonucuburda;
    @FXML
    private ListView<Kimyasal> deney1_solliste;

    @FXML
    private Button phmetredeney_baslabuton;

    @FXML
    void deneyekraninacik(MouseEvent event) {
        sectiginkimyasal_yazisi.setVisible(false);
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
            alert.setHeaderText("Olamaz.Seçtiğiniz Phmetre Kırık Lütfen Başka Bir Phmetre Seçin");
            alert.setContentText("");
            alert.showAndWait();
        }
        else {
            //makine kırık değil işleme devam
            sagSecim.dayaniklilikharca(sagSecim.getDayaniklilik());
            sectiginkimyasal_yazisi.setVisible(true);
            phsonucuburda.setVisible(true);
            phsonucuburda.setText(String.valueOf(solSecim.ph));
            listeleriEkle(); //liste güncellenmeli
        }

    }

    public void listeleriEkle() {
            deney1_solliste.getItems().clear();
            deney1_sagliste.getItems().clear();

            // Kimyasallar için
            deney1_solliste.getItems().addAll(Kim_Asit.asitListesi); // Nesneleri ekle
            deney1_solliste.getItems().addAll(Kim_Baz.bazListesi); // Nesneleri ekle

            // Makineler için
            deney1_sagliste.getItems().addAll(phmetre.tumphmetreler); // Nesneleri ekle


    }


}
