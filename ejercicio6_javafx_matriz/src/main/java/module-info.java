module com.tuempresa.ejercicio6_javafx_matriz {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.ejercicio6_javafx_matriz to javafx.fxml;
    exports com.tuempresa.ejercicio6_javafx_matriz;
}