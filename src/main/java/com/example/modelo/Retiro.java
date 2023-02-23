package com.example.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Retiro extends Transaccion{
    public Retiro(Double valorTransaccion, Estado estado, Transaccion tipoTransaccion, LocalDate fecha) {
        super(valorTransaccion, estado, tipoTransaccion, fecha);
    }

    public Retiro(){
        super();

    }

    @Override
    public String toString() {
        return "Retiro";
    }
}
