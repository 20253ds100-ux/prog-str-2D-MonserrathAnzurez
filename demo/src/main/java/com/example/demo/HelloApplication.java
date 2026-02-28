package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("/views/login.fxml")
        );
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Sistema de Login");
        stage.setScene(scene);
        stage.show();
    }
}