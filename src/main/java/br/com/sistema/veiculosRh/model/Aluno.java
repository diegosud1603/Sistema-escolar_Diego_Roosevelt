package br.com.sistema.veiculosRh.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Aluno extends Pessoa {

    @Column(nullable = false, unique = true)
    private String matricula;

    @ManyToMany
    @JoinTable(name = "aluno_sala",
               joinColumns = @JoinColumn(name = "aluno_id"),
               inverseJoinColumns = @JoinColumn(name = "sala_id"))
    private Set<Sala> salas;

    // Getters and setters
}
