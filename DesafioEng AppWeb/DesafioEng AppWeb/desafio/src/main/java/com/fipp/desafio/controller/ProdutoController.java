package com.fipp.desafio.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fipp.desafio.controll.ProdutoControll;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Produto")
public class ProdutoController {

    private ProdutoControll produtoControll = new ProdutoControll();

    @PostMapping("/insert")
    public ResponseEntity<Object> insertProduto(@RequestBody JsonNode json) throws Exception {
        return ResponseEntity.ok(produtoControll.insertProduto(json));
    }

    @PostMapping("/update")
    public ResponseEntity<Object> updateCidade(@RequestBody JsonNode json) throws Exception {
        return ResponseEntity.ok(produtoControll.updateProduto(json));
    }

    @GetMapping("/delete")
    public ResponseEntity<Object> deleteCidade(@RequestParam(value = "id") int id) throws Exception {
        return ResponseEntity.ok(produtoControll.deleteProduto(id));
    }

    @GetMapping("/produto")
    public ResponseEntity<Object> selectCidade(@RequestParam(value = "id") int id) throws Exception {
        return ResponseEntity.ok(produtoControll.selectProduto(id));
    }

    @GetMapping("/produtos")
    public ResponseEntity<Object> selectCidades(@RequestParam(value = "filtro") String filtro) throws Exception {
        return ResponseEntity.ok(produtoControll.selectProdutos(filtro));
    }
}