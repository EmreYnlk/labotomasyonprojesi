module com.example.labotomasyonproje {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;

    opens com.example.labotomasyonproje to javafx.fxml;
    exports com.example.labotomasyonproje;
}