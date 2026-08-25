package com.tuempresa.ejercicio17_javafx_mcdmcm;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField txtNum1;
    @FXML private TextField txtNum2;
    @FXML private TextArea txtResultado;

    @FXML
    protected void onCalcularClick() {
        try {
            int a = Math.abs(Integer.parseInt(txtNum1.getText().trim()));
            int b = Math.abs(Integer.parseInt(txtNum2.getText().trim()));

            if (a == 0 || b == 0) {
                txtResultado.setText("Error: Los números deben ser distintos de 0.");
                return;
            }

            int mcd = calcularMCD(a, b);
            long mcm = ((long) a * b) / mcd;

            txtResultado.setText("MCD (" + a + ", " + b + "): " + mcd + "\n" +
                    "MCM (" + a + ", " + b + "): " + mcm);

        } catch (NumberFormatException e) {
            txtResultado.setText("Error: Ingresa números enteros válidos.");
        }
    }

    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
