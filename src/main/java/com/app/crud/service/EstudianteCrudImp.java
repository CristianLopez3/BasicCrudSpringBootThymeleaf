package com.app.crud.service;

import com.app.crud.entity.Estudiante;
import com.app.crud.entity.Ficha;
import com.app.crud.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteCrudImp implements EstudianteCrud {

    @Autowired
    private EstudianteRepository repository;
    @Override
    public List<Estudiante> obtenerTodo() {
        return repository.findAll();
    }

    @Override
    public Estudiante obtenerEstudiantePorId(Long id){
        return repository.getReferenceById(id);
    }

    @Override
    public Estudiante registrar(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    @Override
    public Estudiante actualizar(Estudiante estudiante) {
        return repository.save(estudiante);
    }


    @Override
    public void delete(Long id) {
        repository.delete(repository.getReferenceById(id));
    }

    @Override
    public List<Estudiante> listarEstudiantesPorFicha(Ficha ficha) {
        return repository.findByFicha(ficha);
    }


}
