package com.tuempresa.ejercicio4_javafx_frecuencia;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.HashMap;
import java.util.Map;

public class HelloController {
    @FXML private TextField txtNumeros;
    @FXML private TextArea txtResultado;

    @FXML
    protected void onCalcularFrecuenciaClick() {
        try {
            String input = txtNumeros.getText().trim();
            if (input.isEmpty()) {
                txtResultado.setText("Error: Por favor ingresa al menos un número.");
                return;
            }

            String[] partes = input.split(",");
            Map<Integer, Integer> frecuencias = new HashMap<>();

            for (String parte : partes) {
                int num = Integer.parseInt(parte.trim());
                frecuencias.put(num, frecuencias.getOrDefault(num, 0) + 1);
            }

            StringBuilder sb = new StringBuilder("Frecuencia de cada número:\n");
            for (Map.Entry<Integer, Integer> entry : frecuencias.entrySet()) {
                sb.append("Número ").append(entry.getKey()).append(": ")
                        .append(entry.getValue()).append(" vez/veces\n");
            }

            txtResultado.setText(sb.toString());

        } catch (NumberFormatException e) {
            txtResultado.setText("Error: Ingresa números enteros válidos separados por comas.");
        }
    }
}
