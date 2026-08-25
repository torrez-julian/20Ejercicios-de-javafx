module com.tuempresa.ejercicio13_javafx_temperatura {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.ejercicio13_javafx_temperatura to javafx.fxml;
    exports com.tuempresa.ejercicio13_javafx_temperatura;
}