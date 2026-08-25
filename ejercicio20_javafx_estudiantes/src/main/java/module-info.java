module com.tuempresa.ejercicio20_javafx_estudiantes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.ejercicio20_javafx_estudiantes to javafx.fxml;
    exports com.tuempresa.ejercicio20_javafx_estudiantes;
}