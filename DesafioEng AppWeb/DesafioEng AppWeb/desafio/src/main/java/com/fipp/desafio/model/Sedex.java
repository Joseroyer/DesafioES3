package com.fipp.desafio.model;

public class Sedex implements Frete{
    private Frete f;

    @Override
    public void calcular(Entrega e) {
        if (e.getPeso() <= 20) {
            // exectuar o calculo
            e.set(20, 20, "Sedex");
        } else {
            f = new Jadlog();
            f.calcular(e);
        }
    }
}
