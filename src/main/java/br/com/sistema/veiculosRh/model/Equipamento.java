package br.com.sistema.veiculosRh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String numeroPatrimonio;

    @Column(length = 200)
    private String descricao;

    @Column(nullable = false)
    private int anoAquisicao;

    @Enumerated(EnumType.STRING)
    private SituacaoEquipamento situacao;

    @ManyToOne
    @JoinColumn(name = "sala_id", nullable = false)
    private Sala sala;

    

    public SituacaoEquipamento getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoEquipamento situacao) {
        this.situacao = situacao;
    }
    
    public void setSituacaoFromString(String situacao) {
        try {
            this.situacao = SituacaoEquipamento.valueOf(situacao);
        } catch (IllegalArgumentException e) {
            // Tratar o caso em que a String não corresponde a nenhum valor do enum
            System.err.println("Situação inválida: " + situacao);
        }
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroPatrimonio() {
        return numeroPatrimonio;
    }

    public void setNumeroPatrimonio(String numeroPatrimonio) {
        this.numeroPatrimonio = numeroPatrimonio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAnoAquisicao() {
        return anoAquisicao;
    }

    public void setAnoAquisicao(int anoAquisicao) {
        this.anoAquisicao = anoAquisicao;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}

