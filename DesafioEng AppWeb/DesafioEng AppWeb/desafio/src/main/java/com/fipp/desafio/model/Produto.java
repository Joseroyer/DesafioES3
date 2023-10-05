package com.fipp.desafio.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fipp.desafio.util.BDSingleton;
import com.fipp.desafio.util.IDAO;

public class Produto implements IDAO<Produto> {

    private int id;
    private String nome;

    private double preco;

    private int quantidade;

    public Produto() {
    }


    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Produto(int id, String nome, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean insert(Produto entidade) {
        return false;
    }

    @Override
    public boolean update(Produto entidade) {
        return false;
    }

    @Override
    public boolean delete(Produto entidade) {
        return false;
    }

    @Override
    public Produto select(int id) throws Exception {
        Produto produto = null;
        String sql = "select * from produto where id=" + id;
        ResultSet rs = BDSingleton.getCon().consultar(sql);
        try {
            if (rs.next())
                produto = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getDouble("preco"),rs.getInt("quantidade"));
        } catch (Exception e) {
        }
        return produto;
    }

    @Override
    public List<Produto> select(String filtro) throws Exception {
        List<Produto> list = new ArrayList<>();
        String sql = "select * from produto";
        if (!filtro.isEmpty())
            sql += " where " + filtro;
        ResultSet rs = BDSingleton.getCon().consultar(sql);
        try {
            if (rs != null)
                while (rs.next()) {
                    list.add(new Produto(rs.getInt("id"), rs.getString("nome"), rs.getDouble("preco"), rs.getInt("quantidade")));
                }
        } catch (Exception e) {
        }
        return list;
    }
}
