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
    }

    public void retirar(){}
    public void depositar(){

    }
    public void consultar_saldo(){}


}
