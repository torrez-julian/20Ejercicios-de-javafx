package com.tuempresa.ejercicio11_javafx_contador;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML private TextArea txtInput;
    @FXML private TextArea txtResultado;

    @FXML
    protected void onAnalizarClick() {
        String texto = txtInput.getText().trim();
        if (texto.isEmpty()) {
            txtResultado.setText("Error: Escribe un texto para analizar.");
            return;
        }

        int numCaracteresConEspacios = texto.length();
        int numCaracteresSinEspacios = texto.replace(" ", "").length();

        String[] palabras = texto.split("\\s+");
        int numPalabras = palabras.length;

        txtResultado.setText("Cantidad de palabras: " + numPalabras + "\n" +
                "Caracteres (con espacios): " + numCaracteresConEspacios + "\n" +
                "Caracteres (sin espacios): " + numCaracteresSinEspacios);
    }
}
