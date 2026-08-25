package com.tuempresa.ejercicio10_javafx_diagonales;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML private TextField txtValores;
    @FXML private TextArea txtResultado;

    @FXML
    protected void onExtraerClick() {
        try {
            String[] partes = txtValores.getText().trim().split(",");
            if (partes.length != 9) {
                txtResultado.setText("Error: Debes ingresar exactamente 9 números.");
                return;
            }

            int[][] m = new int[3][3];
            int idx = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    m[i][j] = Integer.parseInt(partes[idx++].trim());
                }
            }

            List<Integer> diagPrincipal = new ArrayList<>();
            List<Integer> diagSecundaria = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                diagPrincipal.add(m[i][i]);
                diagSecundaria.add(m[i][2 - i]);
            }

            txtResultado.setText("Diagonal Principal: " + diagPrincipal + "\n" +
                    "Diagonal Secundaria: " + diagSecundaria);

        } catch (NumberFormatException e) {
            txtResultado.setText("Error: Formato numérico inválido.");
        }
    }
}
