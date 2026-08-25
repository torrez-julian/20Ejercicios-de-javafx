package com.tuempresa.ejercicio3_javafx_ordenamiento;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.Arrays;

public class HelloController {
    @FXML private TextField txtNumeros;
    @FXML private TextArea txtResultado;

    @FXML
    protected void onOrdenarClick() {
        try {
            String input = txtNumeros.getText().trim();
            if (input.isEmpty()) {
                txtResultado.setText("Error: Por favor ingresa al menos un número.");
                return;
            }

            String[] partes = input.split(",");
            int[] numeros = new int[partes.length];
            for (int i = 0; i < partes.length; i++) {
                numeros[i] = Integer.parseInt(partes[i].trim());
            }

            int[] original = numeros.clone();
            ordenarBurbuja(numeros);

            txtResultado.setText("Arreglo Original: " + Arrays.toString(original) + "\n" +
                    "Arreglo Ordenado: " + Arrays.toString(numeros));

        } catch (NumberFormatException e) {
            txtResultado.setText("Error: Asegúrate de ingresar solo números enteros separados por coma.");
        }
    }

    private void ordenarBurbuja(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}