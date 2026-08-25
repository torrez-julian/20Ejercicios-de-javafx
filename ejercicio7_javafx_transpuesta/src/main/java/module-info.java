module com.tuempresa.ejercicio7_javafx_transpuesta {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.ejercicio7_javafx_transpuesta to javafx.fxml;
    exports com.tuempresa.ejercicio7_javafx_transpuesta;
}