package com.example.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.example.controlador.AppController.INSTANCE;

public class VistaTransaccionRetirar {
    @FXML
    private TextField tfNumCuenta;
    @FXML
    private TextField tfCantRetirar;
    @FXML
    private Button btnVolver;

    public void OnRetirarClick(){

        String numCuenta = tfNumCuenta.getText();
        double cantRetirar = Double.parseDouble(tfCantRetirar.getText());

        if (INSTANCE.getModel().retirar(numCuenta,cantRetirar)){

            mostrarMensajeInformacion("El retiro ha sido Exitoso");
        }
        else {
            mostrarMensajeInformacion("Fondos insuficientes");
        }

    }
    public  void OnVolverAtras() throws Exception{
        Parent parent = FXMLLoader.load(MainApp.class.getResource("VistaTipoTransaccion.fxml"));
        Scene scene = new Scene(parent, 600, 600);
        Stage stage = new Stage();
        stage.setTitle("Transacion");
        stage.setScene(scene);
        stage.initOwner(btnVolver.getScene().getWindow());
        btnVolver.getScene().getWindow().hide();
        stage.show();

    }

    private void mostrarMensajeInformacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
