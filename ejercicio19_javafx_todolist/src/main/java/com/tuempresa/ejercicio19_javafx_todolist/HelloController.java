package com.tuempresa.ejercicio19_javafx_todolist;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField txtTarea;
    @FXML private ListView<String> listTareas;

    @FXML
    protected void onAgregarClick() {
        String nuevaTarea = txtTarea.getText().trim();
        if (!nuevaTarea.isEmpty()) {
            listTareas.getItems().add(nuevaTarea);
            txtTarea.clear();
        }
    }

    @FXML
    protected void onEliminarClick() {
        int indexSeleccionado = listTareas.getSelectionModel().getSelectedIndex();
        if (indexSeleccionado >= 0) {
            listTareas.getItems().remove(indexSeleccionado);
        }
    }
}
