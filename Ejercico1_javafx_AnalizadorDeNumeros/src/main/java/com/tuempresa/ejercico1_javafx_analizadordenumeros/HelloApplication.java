package com.tuempresa.ejercico1_javafx_analizadordenumeros;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 280);
        stage.setTitle("Ejercicio 1 - Analizador de Números");
        stage.setScene(scene);
        stage.show();
    }
}