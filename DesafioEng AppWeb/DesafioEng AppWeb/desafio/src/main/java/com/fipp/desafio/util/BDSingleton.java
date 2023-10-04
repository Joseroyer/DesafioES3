package com.fipp.desafio.util;

public class BDSingleton {

    private static Conexao con = null;

    static public boolean conectar() {
        if (con == null) {
            con = new Conexao();
            if (con.conectar("org.postgresql.Driver", "jdbc:postgresql://localhost/", "desafio",
                    "postgres", "postgres123"))
                return true;
            else
                return false;
        }
        return false;
    }

    public static Conexao getCon() {
        return con;
    }

    private BDSingleton() {
    }

}
