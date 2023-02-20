package com.example.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private List<Transaccion> transacciones;
    private List<Cuenta> cuentas;
    private List<Cliente> clientes;
    private List<Empleado> empleados;

    public Banco(){
        transacciones = new ArrayList<>();
        cuentas = new ArrayList<>();
        clientes = new ArrayList<>();
        empleados = new ArrayList<>();

        clientes.add(new Cliente("Carlos", "Perez", "1004827192", "123", TipoCuenta.CUENTA_AHORRO));

    }

    public void retirar(Cliente cliente,double cantidad){


    }
    public void depositar(Cliente cliente,double cantidad){


    }
    public void consultar_saldo(){}

    public Cuenta buscarCuenta (String numeroCuenta){

        
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


    public String generarNumeroCuenta() {
        return Math.random();
    }
}
