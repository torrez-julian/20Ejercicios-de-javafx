module com.tuempresa.ejercicio10_javafx_diagonales {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.ejercicio10_javafx_diagonales to javafx.fxml;
    exports com.tuempresa.ejercicio10_javafx_diagonales;
}