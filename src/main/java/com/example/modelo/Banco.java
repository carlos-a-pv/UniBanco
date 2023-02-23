package com.example.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private List<Transaccion> transacciones;
    private List<Cuenta> cuentas;
    private List<Cliente> clientes;
    private List<Empleado> empleados;

    public Banco() {
        transacciones = new ArrayList<>();
        cuentas = new ArrayList<>();
        clientes = new ArrayList<>();
        empleados = new ArrayList<>();

        clientes.add(new Cliente("Carlos", "Perez", "1004827192", TipoCuenta.CUENTA_AHORRO,new Cuenta()));

    }

    public void eliminar(Cliente cliente) {
        clientes.remove(cliente);
    }


    public boolean retirar(String numCuenta, double cantidad) {
        Cliente cuentaAux = clientes.stream().filter(cuenta -> cuenta.getCuenta().getNumCuenta().equals(numCuenta)).findFirst().orElse(null);
        if(cuentaAux.getCuenta().getSaldo()< cantidad) {
            return false;
        }
        else {
            cuentaAux.getCuenta().setSaldo(cuentaAux.getCuenta().getSaldo()-cantidad);
            return true;
        }

    }

    public boolean depositar(String numCuenta, double cantidad) {

        Cliente cuentaAux = clientes.stream().filter(cuenta -> cuenta.getCuenta().getNumCuenta().equals(numCuenta)).findFirst().orElse(null);
        if(cuentaAux == null){
            return false;
        }
        else {
            cuentaAux.getCuenta().setSaldo(cantidad+cuentaAux.getCuenta().getSaldo());
            return true;
        }

    }

    public double consultar_saldo(String numCuenta) {

        Cliente cuentaAux = clientes.stream().filter(cuenta -> cuenta.getCuenta().getNumCuenta().equals(numCuenta)).findFirst().orElse(null);
        if (cuentaAux == null)
            return 0;
        else {
            return  cuentaAux.getCuenta().getSaldo();
        }
    }

    public Cuenta buscarCuenta(String numeroCuenta) {


        return null;
    }

    public List<Cliente> getClientes() {
        return this.clientes;
    }

    public boolean registrarCliente(Cliente cliente) throws Exception {
        Cliente cliente1 = clientes.stream().filter(cliente2 -> cliente2.getCedula().equals(cliente.getCedula())).findFirst().orElse(null);

        if (cliente1 == null) {
            clientes.add(cliente);
            return true;
        } else {
            return false;
        }
    }


    public boolean validarCedula (String cedula){

        if(clientes.stream().map(cliente -> cliente.getCedula().equals(cedula)).findFirst().orElse(null)!= null) {
            return false;
        }
        else {
            return true;
        }
        }
    public boolean validarNumeroCuenta (String numeroCuenta){
            if(clientes.stream().map(cliente -> cliente.getCuenta().getNumCuenta().equals(numeroCuenta)).findFirst().orElse(null)!= null) {
                return false;
            }
            else {
                return true;
            }
        }

    public boolean actualizarCliente(Cliente clienteselection, Cliente cliente) {
        if (cliente != null && clienteselection != null && clientes.stream().filter(cliente1 -> cliente1.getCedula()==cliente.getCedula()).findFirst().orElse(null) != null ) {
            clienteselection.setNombre(cliente.getNombre());
            clienteselection.setApellido(cliente.getApellido());
            clienteselection.setCedula(cliente.getCedula());
            clienteselection.setTipoCuenta(cliente.getTipoCuenta());

            return true;
        }
        else {
            return  false;
        }
    }

    public void addTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }

    public List<Transaccion> getTransaccione() {
        return this.transacciones;
    }
}


