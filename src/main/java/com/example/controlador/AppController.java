package com.example.controlador;
import com.example.modelo.Banco;

public enum AppController {
    INSTANCE;
    private final Banco model;

    AppController() {
        model = new Banco();
    }

    public Banco getModel() {
        return model;
    }
}
