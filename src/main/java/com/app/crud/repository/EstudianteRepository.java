package com.app.crud.repository;

import com.app.crud.entity.Estudiante;
import com.app.crud.entity.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    List<Estudiante> findByFicha(Ficha ficha);

}
