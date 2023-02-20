package com.example.controlador;

import com.example.modelo.Cliente;
import com.example.modelo.Banco;
import com.example.modelo.TipoCuenta;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static com.example.controlador.AppController.INSTANCE;

import java.util.List;

public class PrincipalController{

    @FXML
    private TableView<Cliente> tbClientes;
    @FXML
    private TableColumn<Cliente, String> colNombre;
    @FXML
    private TableColumn<Cliente, String> colApellido;
    @FXML
    private TableColumn<Cliente, String> colCedula;
    @FXML
    private TableColumn<Cliente, String> colNumeroCuenta;
    @FXML
    private TableColumn<Cliente, TipoCuenta> colTipoCuenta;

    private Cliente clienteSeleccionado;

    @FXML
    public void initialize() {

        llenarTabla(INSTANCE.getModel().getClientes());
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory((new PropertyValueFactory<>("apellido")));
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colNumeroCuenta.setCellValueFactory(new PropertyValueFactory<>("numeroCuenta"));
        colTipoCuenta.setCellValueFactory((new PropertyValueFactory<>("tipoCuenta")));

        tbClientes.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> llenarCampos(newValue));
    }

    private void llenarTabla(List<Cliente> clientes) {
        tbClientes.setItems(FXCollections.observableArrayList(clientes));
        tbClientes.refresh();
    }
    private void llenarCampos(Cliente cliente) {
        clienteSeleccionado = cliente;
        if (cliente != null) {


            /*tfNumeroIdentificacion.setText(empleado.getId());
            tfNombre.setText(empleado.getNombre());
            tfCorreo.setText(empleado.getEmail());
            cbGenero.setValue(empleado.getGenero());
            tfContrasena.setText(empleado.getPassword());*/

        }
    }


}