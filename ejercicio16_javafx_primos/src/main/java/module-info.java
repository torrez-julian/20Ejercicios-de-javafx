module com.tuempresa.ejercicio16_javafx_primos {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.ejercicio16_javafx_primos to javafx.fxml;
    exports com.tuempresa.ejercicio16_javafx_primos;
}