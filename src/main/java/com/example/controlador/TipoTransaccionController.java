package com.example.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class TipoTransaccionController {

    @FXML
    private Button btnDepositar;

    @FXML
    private Button btnRetirar;
    @FXML
    private Button btnConsultarSaldo;
    @FXML
    private Button btnVolver;

    public void OnRetirar(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(MainApp.class.getResource("VistaTransaccionRetirar.fxml"));
        Scene scene = new Scene(parent, 600, 600);
        Stage stage = new Stage();
        stage.setTitle("Retirar");
        stage.setScene(scene);
        stage.initOwner(btnRetirar.getScene().getWindow());
        btnRetirar.getScene().getWindow().hide();
        stage.show();
    }

    public void OnConsultarSaldo(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(MainApp.class.getResource("VistaTransaccionConsultarSaldo.fxml"));
        Scene scene = new Scene(parent, 600, 600);
        Stage stage = new Stage();
        stage.setTitle("Consultar Saldo");
        stage.setScene(scene);
        stage.initOwner(btnConsultarSaldo.getScene().getWindow());
        btnConsultarSaldo.getScene().getWindow().hide();
        stage.show();
    }

    public void OnDepositar(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(MainApp.class.getResource("VistaTransaccionDepositar.fxml"));
        Scene scene = new Scene(parent, 600, 600);
        Stage stage = new Stage();
        stage.setTitle("Depositar");
        stage.setScene(scene);
        stage.initOwner(btnDepositar.getScene().getWindow());
        btnDepositar.getScene().getWindow().hide();
        stage.show();

    }

    public  void OnVolverAtras() throws Exception{
        Parent parent = FXMLLoader.load(MainApp.class.getResource("VentanaPrincipal.fxml"));
        Scene scene = new Scene(parent, 900, 700);
        Stage stage = new Stage();
        stage.setTitle("UniBanco empleados");
        stage.setScene(scene);
        stage.initOwner(btnVolver.getScene().getWindow());
        btnVolver.getScene().getWindow().hide();
        stage.show();
    }

}
