module com.tuempresa.ejercicio4_javafx_frecuencia {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.ejercicio4_javafx_frecuencia to javafx.fxml;
    exports com.tuempresa.ejercicio4_javafx_frecuencia;
}