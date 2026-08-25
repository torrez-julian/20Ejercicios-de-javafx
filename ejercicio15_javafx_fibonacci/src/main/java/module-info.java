module com.tuempresa.ejercicio15_javafx_fibonacci {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.ejercicio15_javafx_fibonacci to javafx.fxml;
    exports com.tuempresa.ejercicio15_javafx_fibonacci;
}