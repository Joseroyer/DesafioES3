package com.fipp.desafio.util;

import java.util.List;

public interface IDAO<T> {
    public boolean insert(T entidade);

    public boolean update(T entidade);

    public boolean delete(T entidade);

    public T select(int id) throws Exception;

    public List<T> select(String filtro) throws Exception;
}
