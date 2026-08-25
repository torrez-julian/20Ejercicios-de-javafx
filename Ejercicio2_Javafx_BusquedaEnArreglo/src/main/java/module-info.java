module com.tuempresa.ejercicio2_javafx_busquedaenarreglo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.ejercicio2_javafx_busquedaenarreglo to javafx.fxml;
    exports com.tuempresa.ejercicio2_javafx_busquedaenarreglo;
}