package com.tuempresa.ejercicio2_javafx_busquedaenarreglo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    private static final int TAMANO = 10;
    private double[] numeros = new double[TAMANO];
    private int contador = 0;

    @FXML private TextField txtNumero;
    @FXML private TextField txtBuscar;
    @FXML private Button btnAgregar;
    @FXML private Button btnBuscar;
    @FXML private Button btnReiniciar;
    @FXML private Label lblEstado;
    @FXML private Label lblResultado;

    @FXML
    protected void onAgregarClick() {
        procesarAgregar();
    }

    @FXML
    protected void onBuscarClick() {
        procesarBusqueda();
    }

    @FXML
    protected void onReiniciarClick() {
        limpiarCampos();
    }

    private void procesarAgregar() {
        if (!validarEntradaAgregar()) return;

        try {
            double valor = Double.parseDouble(txtNumero.getText().trim());
            numeros[contador] = valor;
            contador++;
            txtNumero.clear();
            actualizarEstado();

            if (contador == TAMANO) {
                btnAgregar.setDisable(true);
                lblResultado.setText("Arreglo lleno. Puede realizar búsquedas.");
            }
        } catch (NumberFormatException e) {
            lblResultado.setText("Error: Ingrese un número válido.");
        }
    }

    private void procesarBusqueda() {
        if (!validarEntradaBuscar()) return;

        try {
            double objetivo = Double.parseDouble(txtBuscar.getText().trim());
            int apariciones = contarApariciones(objetivo);

            if (apariciones > 0) {
                String posiciones = obtenerPosiciones(objetivo);
                lblResultado.setText(String.format("El número %.2f EXISTE.\nApariciones: %d\nPosiciones (índices): %s", objetivo, apariciones, posiciones));
            } else {
                lblResultado.setText(String.format("El número %.2f NO existe en el arreglo.", objetivo));
            }
        } catch (NumberFormatException e) {
            lblResultado.setText("Error: Ingrese un valor numérico a buscar.");
        }
    }

    private boolean validarEntradaAgregar() {
        if (txtNumero.getText().trim().isEmpty()) {
            lblResultado.setText("Error: Ingrese un número para agregar.");
            return false;
        }
        if (contador >= TAMANO) {
            lblResultado.setText("Error: El arreglo ya está lleno.");
            return false;
        }
        return true;
    }

    private boolean validarEntradaBuscar() {
        if (contador == 0) {
            lblResultado.setText("Error: Primero debe agregar al menos un número.");
            return false;
        }
        if (txtBuscar.getText().trim().isEmpty()) {
            lblResultado.setText("Error: Ingrese un número a buscar.");
            return false;
        }
        return true;
    }

    private int contarApariciones(double valor) {
        int cantidad = 0;
        for (int i = 0; i < contador; i++) {
            if (numeros[i] == valor) {
                cantidad++;
            }
        }
        return cantidad;
    }

    private String obtenerPosiciones(double valor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contador; i++) {
            if (numeros[i] == valor) {
                if (sb.length() > 0) sb.append(", ");
                sb.append(i);
            }
        }
        return sb.toString();
    }

    private void actualizarEstado() {
        lblEstado.setText("Ingresados: " + contador + " de " + TAMANO);
    }

    private void limpiarCampos() {
        numeros = new double[TAMANO];
        contador = 0;
        txtNumero.clear();
        txtBuscar.clear();
        btnAgregar.setDisable(false);
        actualizarEstado();
        lblResultado.setText("Ingrese los números para iniciar la búsqueda.");
    }
}