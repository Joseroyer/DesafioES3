package com.fipp.desafio.controll;

import com.fasterxml.jackson.databind.JsonNode;
import com.fipp.desafio.model.Cidade;
import com.fipp.desafio.model.Produto;

import java.util.List;

public class ProdutoControll {

    private Produto produto = new Produto();

    public boolean insertProduto(JsonNode json) throws Exception {
        Produto novo = new Produto(
                json.get("id").asInt(),
                json.get("nome").asText(),
                json.get("preco").asDouble(),
                json.get("quantidade").asInt());
        return produto.insert(novo);
    }

    public boolean updateProduto(JsonNode json) throws Exception {
        Produto novo = new Produto(
                json.get("id").asInt(),
                json.get("nome").asText(),
                json.get("preco").asDouble(),
                json.get("quantidade").asInt());
        return produto.update(novo);
    }

    public boolean deleteProduto(int id) throws Exception {
        return produto.delete(produto.select(id));
    }

    public Produto selectProduto(int id) throws Exception {
        return produto.select(id);
    }

    public List<Produto> selectProdutos(String filtro) throws Exception {
        return produto.select(filtro);
    }
}
