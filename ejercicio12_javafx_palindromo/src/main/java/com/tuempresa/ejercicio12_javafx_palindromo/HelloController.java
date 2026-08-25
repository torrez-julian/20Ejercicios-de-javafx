package com.tuempresa.ejercicio12_javafx_palindromo;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField txtTexto;
    @FXML private TextArea txtResultado;

    @FXML
    protected void onVerificarClick() {
        String input = txtTexto.getText().trim();
        if (input.isEmpty()) {
            txtResultado.setText("Error: Ingresa texto para verificar.");
            return;
        }

        String limpio = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        String invertido = new StringBuilder(limpio).reverse().toString();

        if (limpio.equals(invertido)) {
            txtResultado.setText("¡Es un palíndromo!\nTexto procesado: " + limpio);
        } else {
            txtResultado.setText("NO es un palíndromo.\nTexto procesado: " + limpio);
        }
    }
}
