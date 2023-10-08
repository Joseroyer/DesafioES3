package com.fipp.desafio.model;

public class Jadlog implements  Frete{
    @Override
    public void calcular(Entrega e) {
        e.set(30, 30, "Jadlog");
    }
}
