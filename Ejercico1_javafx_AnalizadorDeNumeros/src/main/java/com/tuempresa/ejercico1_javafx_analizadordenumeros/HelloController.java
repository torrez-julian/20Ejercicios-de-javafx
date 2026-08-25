package com.tuempresa.ejercico1_javafx_analizadordenumeros;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    // Constante para la cantidad de números requeridos
    private static final int CANTIDAD_NUMEROS = 10;

    // Arreglo y contador global
    private double[] numeros = new double[CANTIDAD_NUMEROS];
    private int contador = 0;

    // Vinculación de elementos UI con la vista FXML
    @FXML
    private TextField txtNumero;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnReiniciar;

    @FXML
    private Label lblEstado;

    @FXML
    private Label lblResultado;

    // =======================================================
    // ACCIONES DE LOS BOTONES (Sigue la regla de oro)
    // =======================================================

    @FXML
    protected void onAgregarClick() {
        procesarAgregar();
    }

    @FXML
    protected void onReiniciarClick() {
        limpiarCampos();
    }

    // =======================================================
    // MÉTODOS DE CONTROL Y LÓGICA DE INTERFAZ
    // =======================================================

    private void procesarAgregar() {
        if (!validarEntrada()) {
            return;
        }

        try {
            double valor = Double.parseDouble(txtNumero.getText().trim());
            numeros[contador] = valor;
            contador++;

            txtNumero.clear();
            actualizarEstado();

            if (contador == CANTIDAD_NUMEROS) {
                mostrarResultados();
                btnAgregar.setDisable(true);
            }
        } catch (NumberFormatException e) {
            lblResultado.setText("Error: Ingrese un número válido.");
        }
    }

    private boolean validarEntrada() {
        if (txtNumero.getText().trim().isEmpty()) {
            lblResultado.setText("Debe ingresar un número.");
            return false;
        }
        if (contador >= CANTIDAD_NUMEROS) {
            lblResultado.setText("Ya se ingresaron los " + CANTIDAD_NUMEROS + " números.");
            return false;
        }
        return true;
    }

    private void actualizarEstado() {
        lblEstado.setText("Ingresados: " + contador + " de " + CANTIDAD_NUMEROS);
    }

    private void mostrarResultados() {
        double suma = calcularSuma(numeros);
        double promedio = calcularPromedio(suma, numeros.length);
        double mayor = obtenerMayor(numeros);
        double menor = obtenerMenor(numeros);
        int pares = contarPares(numeros);
        int impares = contarImpares(numeros);

        String resultadoText = String.format(
                "--- RESULTADOS ---\n" +
                        "Suma: %.2f | Promedio: %.2f\n" +
                        "Mayor: %.2f | Menor: %.2f\n" +
                        "Pares: %d | Impares: %d",
                suma, promedio, mayor, menor, pares, impares
        );

        lblResultado.setText(resultadoText);
    }

    private void limpiarCampos() {
        numeros = new double[CANTIDAD_NUMEROS];
        contador = 0;
        txtNumero.clear();
        btnAgregar.setDisable(false);
        actualizarEstado();
        lblResultado.setText("Ingrese los " + CANTIDAD_NUMEROS + " números para ver los resultados.");
    }

    // =======================================================
    // MÉTODOS DE PROCESAMIENTO (Arreglos y cálculos)
    // =======================================================

    private double calcularSuma(double[] arr) {
        double total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total;
    }

    private double calcularPromedio(double suma, int totalElementos) {
        return suma / totalElementos;
    }

    private double obtenerMayor(double[] arr) {
        double mayor = arr[0];
        for (double num : arr) {
            if (num > mayor) {
                mayor = num;
            }
        }
        return mayor;
    }

    private double obtenerMenor(double[] arr) {
        double menor = arr[0];
        for (double num : arr) {
            if (num < menor) {
                menor = num;
            }
        }
        return menor;
    }

    private int contarPares(double[] arr) {
        int cantidad = 0;
        for (double num : arr) {
            if (num % 1 == 0 && (int) num % 2 == 0) {
                cantidad++;
            }
        }
        return cantidad;
    }

    private int contarImpares(double[] arr) {
        int cantidad = 0;
        for (double num : arr) {
            if (num % 1 == 0 && (int) num % 2 != 0) {
                cantidad++;
            }
        }
        return cantidad;
    }
}