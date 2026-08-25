package com.tuempresa.ejercicio9_javafx_simetrica;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField txtValores;
    @FXML private TextArea txtResultado;

    @FXML
    protected void onVerificarClick() {
        try {
            String input = txtValores.getText().trim();
            String[] partes = input.split(",");

            if (partes.length != 9) {
                txtResultado.setText("Error: Ingresa exactamente 9 números.");
                return;
            }

            int[][] m = new int[3][3];
            int idx = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    m[i][j] = Integer.parseInt(partes[idx++].trim());
                }
            }

            boolean esSimetrica = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (m[i][j] != m[j][i]) {
                        esSimetrica = false;
                        break;
                    }
                }
            }

            StringBuilder sb = new StringBuilder("Matriz ingresada:\n");
            for (int[] fila : m) {
                sb.append("[ ");
                for (int val : fila) {
                    sb.append(val).append(" ");
                }
                sb.append("]\n");
            }
            sb.append("\nResultado: ").append(esSimetrica ? "Es una matriz SIMÉTRICA" : "NO es una matriz simétrica");

            txtResultado.setText(sb.toString());

        } catch (NumberFormatException e) {
            txtResultado.setText("Error: Ingresa enteros válidos.");
        }
    }
}
