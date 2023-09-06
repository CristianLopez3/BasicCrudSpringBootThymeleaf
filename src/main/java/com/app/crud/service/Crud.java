package com.app.crud.service;

import java.util.List;

public interface Crud<T> {

    public List<?> obtenerTodo();

    T registrar(T object);

    T actualizar(T object);

    public void delete(Long id);

}

