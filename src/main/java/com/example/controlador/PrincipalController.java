package com.example.controlador;

import com.example.modelo.Cliente;
import com.example.modelo.Banco;
import com.example.modelo.Cuenta;
import com.example.modelo.TipoCuenta;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import static com.example.controlador.AppController.INSTANCE;


import java.io.IOException;
import java.util.List;

public class PrincipalController{
    @FXML
    private ComboBox cbTipoCuenta;
    @FXML
    private TextField getTextNumCuenta;
    @FXML
    private TextField getTextNombre;
    @FXML
    private TextField getTextApellido;
    @FXML
    private TextField getTextCedula;
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
    @FXML
    private Button btnCrear;
    @FXML
    private Button btnTransaccion;



    private Cliente clienteSeleccionado;

    @FXML
    public void initialize() {
        cbTipoCuenta.setItems(FXCollections.observableArrayList(TipoCuenta.values()));
        llenarTabla(INSTANCE.getModel().getClientes());
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory((new PropertyValueFactory<>("apellido")));
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colNumeroCuenta.setCellValueFactory(new PropertyValueFactory<>("cuenta"));
        colTipoCuenta.setCellValueFactory((new PropertyValueFactory<>("tipoCuenta")));

        tbClientes.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> llenarCampos(newValue));
    }

//    @FXML
//    protected void onCrearButtonClick() throws IOException {
//
//
//        Parent parent = FXMLLoader.load(MainApp.class.getResource("VistaCrearCliente.fxml"));
//        Scene scene = new Scene(parent, 450, 450);
//        Stage stage = new Stage();
//        stage.setTitle("CREAR CLIENTE");
//        stage.setScene(scene);
//        stage.initOwner(btnCrear.getScene().getWindow());
//        btnCrear.getScene().getWindow().hide();
//        stage.show();
//
//    }

    private void llenarTabla(List<Cliente> clientes) {
        tbClientes.setItems(FXCollections.observableArrayList(clientes));
        tbClientes.refresh();
    }
    private void llenarCampos(Cliente cliente) {
        clienteSeleccionado = cliente;
        if (cliente != null) {

           getTextNombre.setText(cliente.getNombre());
            getTextApellido.setText(cliente.getApellido());
            getTextCedula.setText(cliente.getCedula());
            cbTipoCuenta.setValue(cliente.getTipoCuenta());

        }
    }

    @FXML
    public void onActionVentanaTrasaccion(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(MainApp.class.getResource("VistaTipoTransaccion.fxml"));
        Scene scene = new Scene(parent, 600, 600);
        Stage stage = new Stage();
        stage.setTitle("Transaccion");
        stage.setScene(scene);
        stage.initOwner(btnTransaccion.getScene().getWindow());
        btnTransaccion.getScene().getWindow().hide();
        stage.show();

    }
    @FXML
    public void onActionActualizar(ActionEvent actionEvent) throws Exception {
        Cliente cliente = tbClientes.getSelectionModel().getSelectedItem();
//        double saldo = cliente.getCuenta().getSaldo() ;



            String nombre = getTextNombre.getText();
            String apellido = getTextApellido.getText();
            String cedula = getTextCedula.getText();
            TipoCuenta tipoCuenta = (TipoCuenta) cbTipoCuenta.getValue();


            if (INSTANCE.getModel().actualizarCliente(cliente,new Cliente(nombre, apellido, cedula, tipoCuenta,new Cuenta()))) {
                tbClientes.setItems(FXCollections.observableArrayList(INSTANCE.getModel().getClientes()));
                limpiarCampos();
                tbClientes.refresh();
            }
         else{

                mostrarMensajeAdvertencia("El Cliente ya existe");
                limpiarCampos();

        }
    }

    @FXML
    public void obtenerCliente(MouseEvent mouseEvent) {
        Cliente cliente = tbClientes.getSelectionModel().getSelectedItem();

    }

    public void onEliminar(ActionEvent actionEvent) {

       Cliente cliente = tbClientes.getSelectionModel().getSelectedItem();
       INSTANCE.getModel().eliminar(cliente);
        tbClientes.setItems(FXCollections.observableArrayList(INSTANCE.getModel().getClientes()));
        tbClientes.refresh();
    }
    @FXML
    public void onCrearButtonClick(ActionEvent actionEvent) throws Exception {

        if(getTextNombre.getText() != null && getTextApellido.getText() != null && getTextCedula.getText()!= null && cbTipoCuenta != null){
            String nombre = getTextNombre.getText();
            String apellido = getTextApellido.getText();
            String cedula = getTextCedula.getText();
            TipoCuenta tipoCuenta = (TipoCuenta) cbTipoCuenta.getValue();



            if (INSTANCE.getModel().registrarCliente(new Cliente (nombre, apellido, cedula, tipoCuenta,new Cuenta()))){
                tbClientes.setItems(FXCollections.observableArrayList(INSTANCE.getModel().getClientes()));
                limpiarCampos();
                tbClientes.refresh();
            }else{
                mostrarMensajeAdvertencia("EL CLIENTE YA EXISTE");
                limpiarCampos();
            }
        }
    }

    private void mostrarMensajeAdvertencia(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Advertencia");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    private void limpiarCampos(){
        getTextNombre.setText("");
        getTextApellido.setText("");
        getTextCedula.setText("");
        cbTipoCuenta.setValue(null);
    }
    private void mostrarMensajeInformacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}