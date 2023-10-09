package com.fipp.desafio.controller;

import com.fipp.desafio.controll.ProdutoControll;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fipp.desafio.controll.EntregaControll;


@RestController
@RequestMapping("/Venda")
public class EntregaController {

    private ProdutoControll produtoControll = new ProdutoControll();
    private EntregaControll vendaControll = new EntregaControll();



    @PostMapping("/calcularFrete")
    public ResponseEntity<Object> calcularFrete(@RequestBody JsonNode json) throws Exception {
        return ResponseEntity.ok(vendaControll.calcularFrete(json));
    }

    @GetMapping("/produtos")
    public ResponseEntity<Object> selectCidades(@RequestParam(value = "filtro") String filtro) throws Exception {
        return ResponseEntity.ok(produtoControll.selectProdutos(filtro));
    }
}