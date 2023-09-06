package com.app.crud.service;

import com.app.crud.entity.Estudiante;
import com.app.crud.entity.Ficha;

import java.util.List;

public interface EstudianteCrud extends Crud<Estudiante>{

    public List<Estudiante> listarEstudiantesPorFicha(Ficha ficha);

    public Estudiante obtenerEstudiantePorId(Long id);


}
