module com.tuempresa.ejercicio8_javafx_multiplicacion {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.ejercicio8_javafx_multiplicacion to javafx.fxml;
    exports com.tuempresa.ejercicio8_javafx_multiplicacion;
}