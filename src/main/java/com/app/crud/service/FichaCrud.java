package com.app.crud.service;

import com.app.crud.entity.Estudiante;
import com.app.crud.entity.Ficha;

import java.util.List;

public interface FichaCrud extends Crud<Ficha>{

    Ficha registrar(Ficha ficha);

    public Ficha listarUnaSolaFicha(Long id);

}
