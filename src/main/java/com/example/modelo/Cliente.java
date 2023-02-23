package com.example.modelo;

public class Cliente {


    private String nombre;
    private String apellido;
    private String cedula;

    private TipoCuenta tipoCuenta;

    private Cuenta cuenta;

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Cliente(String nombre, String apellido, String cedula, TipoCuenta tipoCuenta, Cuenta cuenta){
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.tipoCuenta = tipoCuenta;
        this.cuenta = cuenta;
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



    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

}
