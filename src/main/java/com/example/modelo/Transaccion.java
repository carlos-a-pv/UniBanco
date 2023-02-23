package com.example.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaccion {
    private double valorTransaccion;
    private Estado estadoTransaccion;
    private Transaccion tipoTransaccion;
    private LocalDate fechaTransaccion;

    public Transaccion(Double valorTransaccion, Estado estado, Transaccion tipoTransaccion, LocalDate fecha){
        this.valorTransaccion = valorTransaccion;
        this.estadoTransaccion = estado;
        this.tipoTransaccion = tipoTransaccion;
        this.fechaTransaccion = fecha;

    }

    public Transaccion() {

    }

    public double getValorTransaccion() {
        return valorTransaccion;
    }

    public Estado getEstadoTransaccion() {
        return estadoTransaccion;
    }

    public Transaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public LocalDate getFechaTransaccion() {
        return fechaTransaccion;
    }


}
