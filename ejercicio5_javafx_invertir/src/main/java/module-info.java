module com.tuempresa.ejercicio5_javafx_invertir {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.ejercicio5_javafx_invertir to javafx.fxml;
    exports com.tuempresa.ejercicio5_javafx_invertir;
}