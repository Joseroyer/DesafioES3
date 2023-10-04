package com.fipp.desafio.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fipp.desafio.util.BDSingleton;
import com.fipp.desafio.util.IDAO;

public class Cidade implements IDAO<Cidade> {
    private int id;
    private String nome;
    private Estado estado;

    public Cidade() {
    }

    public Cidade(int id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean insert(Cidade entidade) {
        String sql = "insert into cidade (nome, estado_id) values ('$1', $2)";
        sql = sql.replace("$1", "" + entidade.getNome());
        sql = sql.replace("$2", "" + entidade.getEstado().getId());
        return BDSingleton.getCon().manipular(sql);
    }

    @Override
    public boolean update(Cidade entidade) {
        String sql = "update cidade set nome= '$1', estado_id= $2 where id=$3";
        sql = sql.replace("$1", "" + entidade.getNome());
        sql = sql.replace("$2", "" + entidade.getEstado().getId());
        sql = sql.replace("$3", "" + entidade.getId());
        return BDSingleton.getCon().manipular(sql);
    }

    @Override
    public boolean delete(Cidade entidade) {
        String sql = "delete from cidade where id=" + entidade.getId();
        return BDSingleton.getCon().manipular(sql);
    }

    @Override
    public Cidade select(int id) throws Exception {
        Cidade obj = null;
        String sql = "select * from cidade where id=" + id;

        ResultSet rs = BDSingleton.getCon().consultar(sql);
        try {
            if (rs.next())
                obj = new Cidade(rs.getInt("id"), rs.getString("nome"),
                        new Estado().select(rs.getInt("estado_id")));
        } catch (Exception e) {
        }
        return obj;
    }

    @Override
    public List<Cidade> select(String filtro) throws Exception {
        List<Cidade> list = new ArrayList<>();
        String sql = "select * from cidade";
        if (!filtro.isEmpty())
            sql += " where " + filtro;
        ResultSet rs = BDSingleton.getCon().consultar(sql);
        try {
            if (rs != null)
                while (rs.next()) {
                    list.add(new Cidade(rs.getInt("id"), rs.getString("nome"),
                            new Estado().select(rs.getInt("estado_id"))));
                }
        } catch (Exception e) {
        }
        return list;
    }

}
