package com.tuempresa.ejercicio6_javafx_matriz;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField txtDatosMatriz;
    @FXML private TextArea txtResultado;

    @FXML
    protected void onCalcularClick() {
        try {
            String input = txtDatosMatriz.getText().trim();
            String[] partes = input.split(",");

            if (partes.length != 9) {
                txtResultado.setText("Error: Debes ingresar exactamente 9 números enteros.");
                return;
            }

            int[][] matriz = new int[3][3];
            int k = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    matriz[i][j] = Integer.parseInt(partes[k++].trim());
                }
            }

            StringBuilder sb = new StringBuilder("Matriz ingresada:\n");
            for (int i = 0; i < 3; i++) {
                sb.append("[ ");
                for (int j = 0; j < 3; j++) {
                    sb.append(matriz[i][j]).append(" ");
                }
                sb.append("]\n");
            }

            sb.append("\nSuma por Filas:\n");
            for (int i = 0; i < 3; i++) {
                int sumaFila = 0;
                for (int j = 0; j < 3; j++) {
                    sumaFila += matriz[i][j];
                }
                sb.append("Fila ").append(i + 1).append(": ").append(sumaFila).append("\n");
            }

            sb.append("\nSuma por Columnas:\n");
            for (int j = 0; j < 3; j++) {
                int sumaCol = 0;
                for (int i = 0; i < 3; i++) {
                    sumaCol += matriz[i][j];
                }
                sb.append("Columna ").append(j + 1).append(": ").append(sumaCol).append("\n");
            }

            txtResultado.setText(sb.toString());

        } catch (NumberFormatException e) {
            txtResultado.setText("Error: Asegúrate de ingresar números enteros válidos.");
        }
    }
}
