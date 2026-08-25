package com.tuempresa.ejercicio20_javafx_estudiantes;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML private TextField txtNombre;
    @FXML private TextField txtNota;
    @FXML private TextArea txtReporte;

    private final List<String> nombres = new ArrayList<>();
    private final List<Double> notas = new ArrayList<>();

    @FXML
    protected void onRegistrarClick() {
        try {
            String nombre = txtNombre.getText().trim();
            double nota = Double.parseDouble(txtNota.getText().trim());

            if (nombre.isEmpty() || nota < 0 || nota > 100) {
                txtReporte.setText("Error: Ingrese un nombre válido y nota entre 0 y 100.");
                return;
            }

            nombres.add(nombre);
            notas.add(nota);

            txtNombre.clear();
            txtNota.clear();

            actualizarReporte();

        } catch (NumberFormatException e) {
            txtReporte.setText("Error: La nota debe ser numérica.");
        }
    }

    @FXML
    protected void onLimpiarClick() {
        nombres.clear();
        notas.clear();
        txtReporte.clear();
    }

    private void actualizarReporte() {
        StringBuilder sb = new StringBuilder("--- LISTA DE ESTUDIANTES ---\n");
        double suma = 0;
        double max = notas.get(0);
        double min = notas.get(0);
        String mejorAlumno = nombres.get(0);

        for (int i = 0; i < nombres.size(); i++) {
            double n = notas.get(i);
            String nom = nombres.get(i);
            sb.append(String.format("%-15s : %.2f\n", nom, n));

            suma += n;
            if (n > max) {
                max = n;
                mejorAlumno = nom;
            }
            if (n < min) {
                min = n;
            }
        }

        double promedio = suma / notas.size();
        sb.append("\nESTADÍSTICAS:\n")
                .append("Total estudiantes: ").append(nombres.size()).append("\n")
                .append(String.format("Promedio General : %.2f\n", promedio))
                .append(String.format("Nota Más Alta    : %.2f (%s)\n", max, mejorAlumno))
                .append(String.format("Nota Más Baja    : %.2f\n", min));

        txtReporte.setText(sb.toString());
    }
}
