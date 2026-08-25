module com.tuempresa.ejercicio17_javafx_mcdmcm {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.ejercicio17_javafx_mcdmcm to javafx.fxml;
    exports com.tuempresa.ejercicio17_javafx_mcdmcm;
}