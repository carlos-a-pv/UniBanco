package com.example.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Deposito extends Transaccion{

    private String tipoTransaccion;
    public Deposito(Double valorTransaccion, Estado estado, Transaccion tipoTransaccion, LocalDate fecha) {
        super(valorTransaccion, estado, tipoTransaccion, fecha);
    }

    public Deposito(){
        super();
        //this.tipoTransaccion = "Deposito";
    }

    @Override
    public String toString() {
        return "Deposito";
    }
}
