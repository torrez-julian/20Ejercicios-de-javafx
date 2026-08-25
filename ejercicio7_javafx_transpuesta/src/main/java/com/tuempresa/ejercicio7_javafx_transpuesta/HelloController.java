package com.tuempresa.ejercicio7_javafx_transpuesta;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField txtValores;
    @FXML private TextArea txtResultado;

    @FXML
    protected void onTransponerClick() {
        try {
            String input = txtValores.getText().trim();
            String[] partes = input.split(",");

            if (partes.length != 6) {
                txtResultado.setText("Error: Debes ingresar exactamente 6 números.");
                return;
            }

            int[][] original = new int[2][3];
            int index = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    original[i][j] = Integer.parseInt(partes[index++].trim());
                }
            }

            int[][] transpuesta = new int[3][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    transpuesta[j][i] = original[i][j];
                }
            }

            StringBuilder sb = new StringBuilder("Matriz Original (2x3):\n");
            sb.append(formatearMatriz(original));
            sb.append("\nMatriz Transpuesta (3x2):\n");
            sb.append(formatearMatriz(transpuesta));

            txtResultado.setText(sb.toString());

        } catch (NumberFormatException e) {
            txtResultado.setText("Error: Ingresa números enteros válidos.");
        }
    }

    private String formatearMatriz(int[][] matriz) {
        StringBuilder sb = new StringBuilder();
        for (int[] fila : matriz) {
            sb.append("[ ");
            for (int val : fila) {
                sb.append(val).append(" ");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }
}
