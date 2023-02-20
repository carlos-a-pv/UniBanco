package com.example.modelo;

public class Cliente {

    private String nombre;
    private String apellido;
    private String cedula;
    private String numeroCuenta;
    private TipoCuenta tipoCuenta;

    public Cliente(String nombre, String apellido, String cedula, String numeroCuenta, TipoCuenta tipoCuenta){
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
    }
    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

}
