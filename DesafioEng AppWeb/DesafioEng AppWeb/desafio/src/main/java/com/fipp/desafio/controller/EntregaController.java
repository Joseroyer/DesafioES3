package com.fipp.desafio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fipp.desafio.controll.EntregaControll;


@RestController
@RequestMapping("/Venda")
public class EntregaController {

    private EntregaControll vendaControll = new EntregaControll();


    @PostMapping("/calcularFrete")
    public ResponseEntity<Object> calcularFrete(@RequestBody JsonNode json) throws Exception {
        return ResponseEntity.ok(vendaControll.calcularFrete(json));
    }
}