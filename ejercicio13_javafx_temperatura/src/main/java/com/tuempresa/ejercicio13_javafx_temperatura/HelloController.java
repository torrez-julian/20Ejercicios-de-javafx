package com.tuempresa.ejercicio13_javafx_temperatura;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField txtGrados;
    @FXML private ComboBox<String> cmbOpciones;
    @FXML private TextArea txtResultado;

    @FXML
    public void initialize() {
        cmbOpciones.getItems().addAll("Celsius a Fahrenheit", "Fahrenheit a Celsius");
        cmbOpciones.getSelectionModel().selectFirst();
    }

    @FXML
    protected void onConvertirClick() {
        try {
            double valor = Double.parseDouble(txtGrados.getText().trim());
            String opcion = cmbOpciones.getValue();
            double res;

            if (opcion.equals("Celsius a Fahrenheit")) {
                res = (valor * 9 / 5) + 32;
                txtResultado.setText(valor + " °C equivale a " + String.format("%.2f", res) + " °F");
            } else {
                res = (valor - 32) * 5 / 9;
                txtResultado.setText(valor + " °F equivale a " + String.format("%.2f", res) + " °C");
            }
        } catch (NumberFormatException e) {
            txtResultado.setText("Error: Ingresa un valor numérico válido.");
        }
    }
}
