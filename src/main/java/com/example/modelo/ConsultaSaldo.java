package com.example.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ConsultaSaldo extends Transaccion{
    public ConsultaSaldo(Double valorTransaccion, Estado estado, Transaccion tipoTransaccion, LocalDate fecha) {
        super(valorTransaccion, estado, tipoTransaccion, fecha);
    }

    public ConsultaSaldo(){
        super();

    }

    @Override
    public String toString() {
        return "ConsultaSaldo";
    }
}
