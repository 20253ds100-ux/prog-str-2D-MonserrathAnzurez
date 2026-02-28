package com.example.demo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {
    @FXML
    private Label lblBienvenida;

    public void setUsuario(String usuario) {
        lblBienvenida.setText("Bienvenido, " + usuario);
    }
}