package com.fipp.desafio.model;

public class Entrega {
    private double peso, distancia, valor;
    private int prazo;
    private String forma;
    private Frete f; // Variavel para atender ao strategy...

    public Entrega() {
    }

    public Entrega(double peso, double distancia) {
        this.peso = peso;
        this.distancia = distancia;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public void set(double valor, int prazo, String forma) {
        this.valor = valor;
        this.prazo = prazo;
        this.forma = forma;
    }

    public void calcular() {
        f = new PAC();
        f.calcular(this);
    }

    public Entrega calcularFrete() {
        calcular();
        return this;
    }
}
