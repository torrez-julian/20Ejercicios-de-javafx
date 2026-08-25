module com.tuempresa.ejercico1_javafx_analizadordenumeros {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.ejercico1_javafx_analizadordenumeros to javafx.fxml;
    exports com.tuempresa.ejercico1_javafx_analizadordenumeros;
}