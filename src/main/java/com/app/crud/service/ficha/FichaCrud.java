package com.app.crud.service.ficha;

import com.app.crud.entity.Estudiante;
import com.app.crud.entity.Ficha;
import com.app.crud.service.Crud;

import java.util.List;

public interface FichaCrud extends Crud<Ficha> {

    Ficha registrar(Ficha ficha);

    Ficha obtenerFichaPorId(Long id);
    public Ficha listarUnaSolaFicha(Long id);

}
