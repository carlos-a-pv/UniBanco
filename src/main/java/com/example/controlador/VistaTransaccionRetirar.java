package com.example.controlador;

import com.example.modelo.Estado;
import com.example.modelo.Retiro;
import com.example.modelo.Transaccion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

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
        String cantRetirar = tfCantRetirar.getText();

        if(!numCuenta.equals(null) && !cantRetirar.equals(null)){

            if(INSTANCE.getModel().validarNumeroCuenta(numCuenta)){
                Double cantRetirar2 = Double.parseDouble(tfCantRetirar.getText());
                if (INSTANCE.getModel().retirar(numCuenta,cantRetirar2)){
                    mostrarMensajeInformacion("El retiro ha sido Exitoso");
                    INSTANCE.getModel().addTransaccion(new Transaccion(cantRetirar2, Estado.EXISTOSA, new Retiro(), LocalDate.now()));
                }else {
                    mostrarMensajeInformacion("Fondos insuficientes");
                    INSTANCE.getModel().addTransaccion(new Transaccion(0.0, Estado.SIN_FONDOS, new Retiro(), LocalDate.now()));
                }
            }else{
                mostrarMensajeAdvertencia("La cuenta no se encuentra registrada.");
                INSTANCE.getModel().addTransaccion(new Transaccion(0.0, Estado.RECHAZADA, new Retiro(), LocalDate.now()));
                tfCantRetirar.setText("");
                tfNumCuenta.setText("");
            }
        }else{
            mostrarMensajeAdvertencia("LENE LOS CAMPOS!!!");
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

    private void mostrarMensajeAdvertencia(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Advertencia");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
