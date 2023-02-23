package com.example.modelo;

public class Cuenta {
    public double saldo;
    public String numCuenta;

    @Override
    public String toString() {
        return numCuenta;
    }

    public Cuenta() {
        this.saldo = 0;
        this.numCuenta = String.valueOf( (int) (Math. floor(Math. random()*(10000-1+1)+1)));
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
