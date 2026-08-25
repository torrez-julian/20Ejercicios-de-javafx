module com.tuempresa.ejercicio9_javafx_simetrica {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.ejercicio9_javafx_simetrica to javafx.fxml;
    exports com.tuempresa.ejercicio9_javafx_simetrica;
}