package com.example.controlador;

import com.example.modelo.Cliente;
import com.example.modelo.Estado;
import com.example.modelo.TipoCuenta;
import com.example.modelo.Transaccion;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.controlador.AppController.INSTANCE;

public class VistaTransaccionesController {

    @FXML
    private TableView<Transaccion> tbTransacciones;
    @FXML
    private TableColumn<Transaccion, Double> colValor;
    @FXML
    private TableColumn<Transaccion, Transaccion> colTipoTransaccion;
    @FXML
    private TableColumn<Transaccion, Estado> colEstado;
    @FXML
    private TableColumn<Transaccion, LocalDateTime> colFecha;
    @FXML
    private Button btnVolverClick;

    @FXML
    public void initialize() {
        llenarTabla(INSTANCE.getModel().getTransaccione());

        colTipoTransaccion.setCellValueFactory(new PropertyValueFactory<>("tipoTransaccion"));
        colValor.setCellValueFactory((new PropertyValueFactory<>("valorTransaccion")));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estadoTransaccion"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaTransaccion"));


        //tbClientes.getSelectionModel().selectedItemProperty()
        //        .addListener((observable, oldValue, newValue) -> llenarCampos(newValue));
    }

    private void llenarTabla(List<Transaccion> transacciones) {
        tbTransacciones.setItems(FXCollections.observableArrayList(transacciones));
        tbTransacciones.refresh();
    }

    public void OnVolverClick(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(MainApp.class.getResource("VentanaPrincipal.fxml"));
        Scene scene = new Scene(parent, 900, 700);
        Stage stage = new Stage();
        stage.setTitle("Transacion");
        stage.setScene(scene);
        stage.initOwner(btnVolverClick.getScene().getWindow());
        btnVolverClick.getScene().getWindow().hide();
        stage.show();
    }
}
