package com.fipp.desafio.controll;

import com.fipp.desafio.model.Produto;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fipp.desafio.model.Entrega;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntregaControll {
    private Entrega entrega = new Entrega();
    private Produto produto = new Produto();

    public Entrega calcularFrete(@RequestBody JsonNode json) {
        if (json.get("peso").asDouble() != 0 && json.get("peso").asDouble() != 0) {
            entrega.setPeso(json.get("peso").asDouble());
            entrega.setDistancia(json.get("distancia").asDouble());

            entrega.calcularFrete();

            Entrega entregaResultado = new Entrega();

            return entregaResultado = entrega;
        }
        return null;
    }

    public List<Produto> selectProdutos(String filtro) throws Exception {
        return produto.select(filtro);
    }

}
