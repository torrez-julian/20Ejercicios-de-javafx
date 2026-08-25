module com.tuempresa.ejercicio12_javafx_palindromo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.ejercicio12_javafx_palindromo to javafx.fxml;
    exports com.tuempresa.ejercicio12_javafx_palindromo;
}