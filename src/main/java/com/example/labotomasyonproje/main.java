package com.example.labotomasyonproje;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("giris-ekrani.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 478, 588);
        stage.setTitle("Uygulamaya Giriş");
        stage.setScene(scene);
        stage.show();
    }
}

