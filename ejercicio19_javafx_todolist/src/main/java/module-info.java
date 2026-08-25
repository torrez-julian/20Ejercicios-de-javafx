module com.tuempresa.ejercicio19_javafx_todolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tuempresa.ejercicio19_javafx_todolist to javafx.fxml;
    exports com.tuempresa.ejercicio19_javafx_todolist;
}