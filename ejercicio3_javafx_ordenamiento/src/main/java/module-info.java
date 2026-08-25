module com.tuempresa.ejercicio3_javafx_ordenamiento {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.ejercicio3_javafx_ordenamiento to javafx.fxml;
    exports com.tuempresa.ejercicio3_javafx_ordenamiento;
}