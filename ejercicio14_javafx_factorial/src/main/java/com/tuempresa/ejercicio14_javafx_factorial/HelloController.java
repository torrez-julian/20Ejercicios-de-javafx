package com.tuempresa.ejercicio14_javafx_factorial;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField txtNumero;
    @FXML private TextArea txtResultado;

    @FXML
    protected void onCalcularClick() {
        try {
            int n = Integer.parseInt(txtNumero.getText().trim());
            if (n < 0 || n > 20) {
                txtResultado.setText("Error: Ingresa un entero entre 0 y 20.");
                return;
            }

            long fact = 1;
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }

            txtResultado.setText("El factorial de " + n + " (" + n + "!) es:\n" + fact);

        } catch (NumberFormatException e) {
            txtResultado.setText("Error: Ingresa un número entero válido.");
        }
    }
}