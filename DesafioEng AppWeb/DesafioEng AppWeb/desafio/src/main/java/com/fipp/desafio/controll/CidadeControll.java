package com.fipp.desafio.controll;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fipp.desafio.model.Cidade;
import com.fipp.desafio.model.Estado;

public class CidadeControll {

    private Cidade cidade = new Cidade();
    private Estado estado = new Estado();

    public boolean insertCidade(JsonNode json) throws Exception {
        Cidade novo = new Cidade(
                json.get("id").asInt(),
                json.get("nome").asText(),
                selectEstado(json.get("estado").asInt()));
        return cidade.insert(novo);
    }

    public boolean updateCidade(JsonNode json) throws Exception {
        Cidade novo = new Cidade(
                json.get("id").asInt(),
                json.get("nome").asText(),
                selectEstado(json.get("estado").asInt()));
        return cidade.update(novo);
    }

    public boolean deleteCidade(int id) throws Exception {
        return cidade.delete(cidade.select(id));
    }

    public Cidade selectCidade(int id) throws Exception {
        return cidade.select(id);
    }

    public List<Cidade> selectCidades(String filtro) throws Exception {
        return cidade.select(filtro);
    }

    // *** RECUPERAR DADOS DE ESTADO ***

    public Estado selectEstado(int id) throws Exception {
        return estado.select(id);
    }

    public List<Estado> selectEstados(String filtro) throws Exception {
        return estado.select(filtro);
    }
}
