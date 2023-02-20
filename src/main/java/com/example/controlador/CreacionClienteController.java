package com.example.controlador;

import com.example.modelo.Cliente;
import com.example.modelo.TipoCuenta;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static com.example.controlador.AppController.INSTANCE;
import java.io.IOException;

public class CreacionClienteController {

    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellido;
    @FXML
    private TextField tfCedula;
    @FXML
    private TextField tfNumeroCuenta;
    @FXML
    private ComboBox cbTipoCuenta;
    @FXML
    private Button btnCrearCliente;

    @FXML
    public void initialize() {
        tfNumeroCuenta.setText( INSTANCE.getModel().generarNumeroCuenta() );
        cbTipoCuenta.setItems(FXCollections.observableArrayList(TipoCuenta.values()));
    }


    @FXML
    protected void onCrearClienteClick() throws Exception {

        if(tfNombre != null && tfApellido != null && tfCedula != null && tfNumeroCuenta != null && cbTipoCuenta != null){
            String nombre = tfNombre.getText();
            String apellido = tfApellido.getText();
            String cedula = tfCedula.getText();
            String numeroCuenta = tfNumeroCuenta.getText();
            TipoCuenta tipoCuenta = (TipoCuenta) cbTipoCuenta.getValue();

            if (INSTANCE.getModel().registrarCliente(new Cliente(nombre, apellido, cedula, numeroCuenta, tipoCuenta)) == true){
                Parent parent = FXMLLoader.load(MainApp.class.getResource("VentanaPrincipal.fxml"));
                Scene scene = new Scene(parent, 450, 450);
                Stage stage = new Stage();
                stage.setTitle("CREAR CLIENTE");
                stage.setScene(scene);
                stage.initOwner(btnCrearCliente.getScene().getWindow());
                btnCrearCliente.getScene().getWindow().hide();
                stage.show();
            }else{
                mostrarMensajeAdvertencia("EL CLIENTE YA EXISTE");
                tfNombre.setText("");
                tfApellido.setText("");
                tfCedula.setText("");
                tfNumeroCuenta.setText("");
                cbTipoCuenta.setValue(null);
            }
        }
    }

    private void mostrarMensajeAdvertencia(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Advertencia");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


}
