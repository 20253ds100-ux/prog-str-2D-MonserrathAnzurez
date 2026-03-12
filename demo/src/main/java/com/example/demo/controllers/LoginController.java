package com.example.demo.controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.io.IOException;
public class LoginController {
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtCorreo;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label lblError;
    @FXML
    private void handleLogin() throws IOException {
        String usuario = txtUsuario.getText();
        String correo = txtCorreo.getText();
        String password = txtPassword.getText();
        if (usuario.isEmpty() || usuario.length() < 4) {
            lblError.setText("Usuario mínimo 4 caracteres");
            return;
        }if (!correo.contains("@") || !correo.contains(".")) {
            lblError.setText("Correo no válido");
            return;
        }if (password.length() < 6) {
            lblError.setText("Contraseña mínimo 6 caracteres");
            return;
        }FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/views/dashboard.fxml")
        );Parent root = loader.load();
        DashboardController dashboardController = loader.getController();
        dashboardController.setUsuario(usuario);
        Stage stage = (Stage) txtUsuario.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}