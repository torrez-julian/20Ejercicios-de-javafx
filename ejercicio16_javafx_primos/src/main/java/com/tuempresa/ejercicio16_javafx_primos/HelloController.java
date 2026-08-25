package com.tuempresa.ejercicio16_javafx_primos;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField txtNumero;
    @FXML private TextArea txtResultado;

    @FXML
    protected void onVerificarClick() {
        try {
            int num = Integer.parseInt(txtNumero.getText().trim());
            if (esPrimo(num)) {
                txtResultado.setText("El número " + num + " es PRIMO.");
            } else {
                txtResultado.setText("El número " + num + " NO es primo.");
            }
        } catch (NumberFormatException e) {
            txtResultado.setText("Error: Ingresa un entero válido.");
        }
    }

    private boolean esPrimo(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
