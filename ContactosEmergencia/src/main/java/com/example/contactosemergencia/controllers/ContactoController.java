package com.example.contactosemergencia.controllers;
import com.example.contactosemergencia.models.Contacto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
public class ContactoController {
    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;
    @FXML private ComboBox<String> cbParentesco;
    @FXML private ListView<Contacto> listView;
    @FXML private Label lblMsg;
    private ObservableList<Contacto> lista = FXCollections.observableArrayList();
    private String[] parentescos = {
            "Padre","Madre","Hermano","Hermana", "Abuelo","Abuela","Tío","Tía"
    };
    @FXML
    public void initialize() {
        cbParentesco.getItems().addAll(parentescos);
        listView.setItems(lista);
    }
    @FXML
    public void onAdd() {
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String parentesco = cbParentesco.getValue();
        if (!validar(nombre, telefono, parentesco)) return;
        for (Contacto c : lista) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                mensaje("Ya existe ese nombre", false);
                return;
            }
        }
        lista.add(new Contacto(nombre, telefono, parentesco));
        mensaje("Agregado correctamente", true);
        limpiar();
    }
    @FXML
    public void onBuscar() {
        String nombre = txtNombre.getText();
        for (Contacto c : lista) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                txtTelefono.setText(c.getTelefono());
                cbParentesco.setValue(c.getParentesco());
                mensaje("Encontrado", true);
                return;
            }

        }
        mensaje("No encontrado", false);
    }
    @FXML
    public void onActualizar() {
        String nombre = txtNombre.getText();
        for (Contacto c : lista) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                c.setTelefono(txtTelefono.getText());
                c.setParentesco(cbParentesco.getValue());
                listView.refresh();
                mensaje("Actualizado", true);
                return;
            }
        }
        mensaje("No encontrado", false);
    }

    @FXML
    public void onDelete() {
        String nombre = txtNombre.getText();
        Contacto eliminar = null;
        for (Contacto c : lista) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                eliminar = c;
            }
        }if (eliminar != null) {
            lista.remove(eliminar);
            mensaje("Eliminado", true);
            limpiar();
        } else {
            mensaje("No encontrado", false);
        }
    }
    @FXML
    public void onLimpiar() {
        limpiar();
    }
    private void limpiar() {
        txtNombre.clear();
        txtTelefono.clear();
        cbParentesco.setValue(null);
    }
    private boolean validar(String n, String t, String p) {
        if (n.isEmpty()) {
            mensaje("Nombre vacío", false);
            return false;
        }if (!t.matches("\\d{10}")) {
            mensaje("Teléfono inválido", false);
            return false;
        }if (p == null) {
            mensaje("Selecciona parentesco", false);
            return false;
        }
        return true;
    }
    private void mensaje(String msg, boolean ok) {
        lblMsg.setText(msg);
        lblMsg.setStyle(ok ? "-fx-text-fill: green" : "-fx-text-fill: red");
    }
}