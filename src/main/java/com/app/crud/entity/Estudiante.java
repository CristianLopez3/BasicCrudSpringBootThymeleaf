package com.app.crud.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "estudiantes")
@Data
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String documento;
    private String edad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numero_de_ficha")
    private Ficha ficha;



}
