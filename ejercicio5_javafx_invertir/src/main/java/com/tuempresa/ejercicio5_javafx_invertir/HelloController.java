package com.tuempresa.ejercicio5_javafx_invertir;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.Arrays;

public class HelloController {
    @FXML private TextField txtNumeros;
    @FXML private TextArea txtResultado;

    @FXML
    protected void onInvertirClick() {
        try {
            String input = txtNumeros.getText().trim();
            if (input.isEmpty()) {
                txtResultado.setText("Error: Por favor ingresa datos.");
                return;
            }

            String[] elementos = input.split(",");
            for (int i = 0; i < elementos.length; i++) {
                elementos[i] = elementos[i].trim();
            }

            String[] original = elementos.clone();
            invertirArreglo(elementos);

            txtResultado.setText("Original: " + Arrays.toString(original) + "\n" +
                    "Invertido: " + Arrays.toString(elementos));

        } catch (Exception e) {
            txtResultado.setText("Error al procesar los datos.");
        }
    }

    private void invertirArreglo(String[] arr) {
        int inicio = 0;
        int fin = arr.length - 1;
        while (inicio < fin) {
            String temp = arr[inicio];
            arr[inicio] = arr[fin];
            arr[fin] = temp;
            inicio++;
            fin--;
        }
    }
}