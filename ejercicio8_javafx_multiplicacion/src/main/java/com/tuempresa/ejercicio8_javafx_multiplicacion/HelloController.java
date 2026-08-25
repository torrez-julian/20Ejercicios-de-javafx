package com.tuempresa.ejercicio8_javafx_multiplicacion;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField txtMatrizA;
    @FXML private TextField txtMatrizB;
    @FXML private TextArea txtResultado;

    @FXML
    protected void onMultiplicarClick() {
        try {
            int[][] a = parsearMatriz2x2(txtMatrizA.getText().trim());
            int[][] b = parsearMatriz2x2(txtMatrizB.getText().trim());

            if (a == null || b == null) {
                txtResultado.setText("Error: Ambas matrices deben contener exactamente 4 números enteros.");
                return;
            }

            int[][] c = new int[2][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    c[i][j] = 0;
                    for (int k = 0; k < 2; k++) {
                        c[i][j] += a[i][k] * b[k][j];
                    }
                }
            }

            StringBuilder sb = new StringBuilder("Resultado A x B (2x2):\n");
            for (int i = 0; i < 2; i++) {
                sb.append("[ ");
                for (int j = 0; j < 2; j++) {
                    sb.append(c[i][j]).append(" ");
                }
                sb.append("]\n");
            }

            txtResultado.setText(sb.toString());

        } catch (NumberFormatException e) {
            txtResultado.setText("Error: Ingresa únicamente números enteros válidos.");
        }
    }

    private int[][] parsearMatriz2x2(String input) {
        String[] partes = input.split(",");
        if (partes.length != 4) return null;

        int[][] m = new int[2][2];
        m[0][0] = Integer.parseInt(partes[0].trim());
        m[0][1] = Integer.parseInt(partes[1].trim());
        m[1][0] = Integer.parseInt(partes[2].trim());
        m[1][1] = Integer.parseInt(partes[3].trim());
        return m;
    }
}
