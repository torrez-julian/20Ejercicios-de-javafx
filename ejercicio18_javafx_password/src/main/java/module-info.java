module com.tuempresa.ejercicio18_javafx_password {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.ejercicio18_javafx_password to javafx.fxml;
    exports com.tuempresa.ejercicio18_javafx_password;
}