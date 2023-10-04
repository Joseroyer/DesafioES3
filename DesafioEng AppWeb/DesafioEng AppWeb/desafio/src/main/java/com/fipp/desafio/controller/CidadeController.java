package com.fipp.desafio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fipp.desafio.controll.CidadeControll;

@RestController
@RequestMapping("/Cidade")
public class CidadeController {

    private CidadeControll cidadeControll = new CidadeControll();

    @PostMapping("/insert")
    public ResponseEntity<Object> insertCidade(@RequestBody JsonNode json) throws Exception {
        return ResponseEntity.ok(cidadeControll.insertCidade(json));
    }

    @PostMapping("/update")
    public ResponseEntity<Object> updateCidade(@RequestBody JsonNode json) throws Exception {
        return ResponseEntity.ok(cidadeControll.updateCidade(json));
    }

    @GetMapping("/delete")
    public ResponseEntity<Object> deleteCidade(@RequestParam(value = "id") int id) throws Exception {
        return ResponseEntity.ok(cidadeControll.deleteCidade(id));
    }

    @GetMapping("/cidade")
    public ResponseEntity<Object> selectCidade(@RequestParam(value = "id") int id) throws Exception {
        return ResponseEntity.ok(cidadeControll.selectCidade(id));
    }

    @GetMapping("/cidades")
    public ResponseEntity<Object> selectCidades(@RequestParam(value = "filtro") String filtro) throws Exception {
        return ResponseEntity.ok(cidadeControll.selectCidades(filtro));
    }

    // *** RECUPERAR DADOS DE ESTADO ***

    @GetMapping("/estados") // RECUPERA TODOS OS ESTADOS
    public ResponseEntity<Object> selectEstados(@RequestParam(required = false) String filtro) throws Exception {
        return ResponseEntity.ok(cidadeControll.selectEstados(filtro));
    }
}
