package com.app.crud.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "ficha")
@Data
public class Ficha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String programa;
    @OneToMany(mappedBy = "ficha")
    private List<Estudiante> estudianteList;

}
