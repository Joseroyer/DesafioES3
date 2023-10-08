package com.fipp.desafio.model;

public class PAC implements Frete {
    private Frete f;

    @Override
    public void calcular(Entrega e) {
        if (e.getPeso() <= 10) {
            // exectuar o calculo
            e.set(10, 10, "PAC");
        } else {
//            f = new Sedex();
            f = new Sedex();
            f.calcular(e);
        }
    }
}
