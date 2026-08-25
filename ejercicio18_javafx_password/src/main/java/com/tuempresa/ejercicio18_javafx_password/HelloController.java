package com.tuempresa.ejercicio18_javafx_password;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML private PasswordField txtPassword;
    @FXML private TextArea txtResultado;

    @FXML
    protected void onValidarClick() {
        String pass = txtPassword.getText();

        boolean longitud = pass.length() >= 8;
        boolean mayuscula = pass.matches(".*[A-Z].*");
        boolean minuscula = pass.matches(".*[a-z].*");
        boolean numero = pass.matches(".*[0-9].*");
        boolean especial = pass.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");

        StringBuilder sb = new StringBuilder("Requisitos de Seguridad:\n");
        sb.append(longitud ? "[✓]" : "[✗]").append(" Mínimo 8 caracteres\n");
        sb.append(mayuscula ? "[✓]" : "[✗]").append(" Al menos una mayúscula\n");
        sb.append(minuscula ? "[✓]" : "[✗]").append(" Al menos una minúscula\n");
        sb.append(numero ? "[✓]" : "[✗]").append(" Al menos un número\n");
        sb.append(especial ? "[✓]" : "[✗]").append(" Al menos un carácter especial\n\n");

        if (longitud && mayuscula && minuscula && numero && especial) {
            sb.append("ESTADO: ¡Contraseña VÁLIDA y segura!");
        } else {
            sb.append("ESTADO: Contraseña INSEGURA.");
        }

        txtResultado.setText(sb.toString());
    }
}
