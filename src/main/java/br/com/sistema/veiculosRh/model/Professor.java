package br.com.sistema.veiculosRh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public abstract class Professor extends Pessoa {

    @Column(nullable = false, unique = true)
    private String matricula;

    @Enumerated(EnumType.STRING)
    private TipoProfessor tipo;

    // Getters and setters
}

