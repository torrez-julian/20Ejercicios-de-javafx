module com.tuempresa.ejercicio11_javafx_contador {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.ejercicio11_javafx_contador to javafx.fxml;
    exports com.tuempresa.ejercicio11_javafx_contador;
}