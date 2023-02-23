package com.example.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.Instant;
import static com.example.controlador.AppController.INSTANCE;

public class VistaTransaccionConsultarSaldo {

    @FXML

    private TextField tfNumCuenta;
    @FXML
    private Text textSalida;

    @FXML
    Button btnSaldo;
    @FXML
    Button btnVolver;

    public void OnConsultaClick(ActionEvent actionEvent) {

      String numCuenta =  tfNumCuenta.getText();

       double saldo = INSTANCE.getModel().consultar_saldo(numCuenta);

       textSalida.setText("El saldo de la cuenta es : "+String.valueOf(saldo));
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
}
