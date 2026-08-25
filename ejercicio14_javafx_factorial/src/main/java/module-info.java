module com.tuempresa.ejercicio14_javafx_factorial {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.ejercicio14_javafx_factorial to javafx.fxml;
    exports com.tuempresa.ejercicio14_javafx_factorial;
}