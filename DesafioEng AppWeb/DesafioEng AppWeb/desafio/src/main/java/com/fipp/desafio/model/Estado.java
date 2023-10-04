package com.fipp.desafio.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fipp.desafio.util.BDSingleton;
import com.fipp.desafio.util.IDAO;

public class Estado implements IDAO<Estado> {

    private int id;
    private String sigla;
    private String nome;

    public Estado() {
    }

    public Estado(int id, String sigla, String nome) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean insert(Estado entidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public boolean update(Estado entidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Estado entidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Estado select(int id) throws Exception {
        Estado estado = null;
        String sql = "select * from estado where id=" + id;
        ResultSet rs = BDSingleton.getCon().consultar(sql);
        try {
            if (rs.next())
                estado = new Estado(rs.getInt("id"), rs.getString("sigla"), rs.getString("nome"));
        } catch (Exception e) {
        }
        return estado;
    }

    @Override
    public List<Estado> select(String filtro) throws Exception {
        List<Estado> list = new ArrayList<>();
        String sql = "select * from estado";
        if (!filtro.isEmpty())
            sql += " where " + filtro;
        ResultSet rs = BDSingleton.getCon().consultar(sql);
        try {
            if (rs != null)
                while (rs.next()) {
                    list.add(new Estado(rs.getInt("id"), rs.getString("sigla"), rs.getString("nome")));
                }
        } catch (Exception e) {
        }
        return list;
    }
}
