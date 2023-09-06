package com.app.crud.service.ficha;

import com.app.crud.entity.Ficha;
import com.app.crud.repository.FichaRepository;
import com.app.crud.service.ficha.FichaCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichaCrudImp implements FichaCrud {

    @Autowired
    private FichaRepository repository;

    @Override
    public List<Ficha> obtenerTodo() {
        return repository.findAll();
    }

    @Override
    public Ficha registrar(Ficha ficha) {
        return repository.save(ficha);
    }

    @Override
    public Ficha actualizar(Ficha ficha) {
        return repository.save(ficha);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Ficha listarUnaSolaFicha(Long id) {
        return repository.getReferenceById(id);
    }


}
