package com.app.crud.repository;

import com.app.crud.entity.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaRepository extends JpaRepository<Ficha, Long> {
    Ficha findByNumero(String numero);
    
}
