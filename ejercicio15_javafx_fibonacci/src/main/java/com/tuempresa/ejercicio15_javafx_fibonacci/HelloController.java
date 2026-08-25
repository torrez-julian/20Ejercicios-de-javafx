package com.tuempresa.ejercicio15_javafx_fibonacci;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField txtLimite;
    @FXML private TextArea txtResultado;

    @FXML
    protected void onGenerarClick() {
        try {
            int n = Integer.parseInt(txtLimite.getText().trim());
            if (n <= 0) {
                txtResultado.setText("Error: Ingresa un número mayor a 0.");
                return;
            }

            StringBuilder sb = new StringBuilder();
            long a = 0, b = 1;

            for (int i = 0; i < n; i++) {
                sb.append(a).append(i == n - 1 ? "" : ", ");
                long temp = a + b;
                a = b;
                b = temp;
            }

            txtResultado.setText("Serie de Fibonacci (" + n + " términos):\n" + sb.toString());

        } catch (NumberFormatException e) {
            txtResultado.setText("Error: Ingresa un número entero positivo.");
        }
    }
}
