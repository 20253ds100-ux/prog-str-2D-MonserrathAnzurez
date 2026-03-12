package com.example.demolistview.controllers;
import com.example.demolistview.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;
public class AppController {
    @FXML
    private ListView<String> listView;
    @FXML
    private Label lblMsg;
    @FXML
    private TextField textName;
    @FXML
    private TextField textEmail;
    @FXML
    private TextField textEdad;
    @FXML
    private final ObservableList<String> data = FXCollections.observableArrayList();
    private PersonService service= new PersonService();
    @FXML
    public void initialize(){ //se va a ejecutar el inicio, en cuanto se cargue el controller
        //Inicializar ListView
        loadFromFile();
        listView.setItems(data);
    }
    public void onAddPerson(){
        try {
            String name = textName.getText();
            String email = textEmail.getText();
            String edadText = textEdad.getText();
            int edad = Integer.parseInt(edadText);
            service.addPerson(name, email, edad);
            lblMsg.setText("Persona agregada con exito");
            lblMsg.setStyle("-fx-text-fill: green");
            textName.clear();
            textEmail.clear();
            textEdad.clear();
            loadFromFile();
        }catch (NumberFormatException nfe){
            lblMsg.setText("Hubo un error con la edad, solo numeros");
            lblMsg.setStyle("-fx-text-fill: red");
        }catch(IOException e){
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: red");
        }catch (IllegalArgumentException ex){
            lblMsg.setText(ex.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
    private void loadFromFile(){
        try{
            List<String> items = service.loadDataforList();
            data.setAll(items);
            lblMsg.setText("Datos cargados exitosamente ");
            lblMsg.setStyle("-fx-text-fill: green");
        } catch (IOException e) {
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
}