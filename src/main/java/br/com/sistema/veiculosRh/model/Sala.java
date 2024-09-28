package br.com.sistema.veiculosRh.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String bloco;

    private String apelido;

    @Enumerated(EnumType.STRING)
    private TipoSala tipo;

    @OneToMany(mappedBy = "sala")
    private Set<Equipamento> equipamentos;

    // Getters and setters
        // Getters e Setters

        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public String getNumero() {
            return numero;
        }
    
        public void setNumero(String numero) {
            this.numero = numero;
        }
    
        public String getBloco() {
            return bloco;
        }
    
        public void setBloco(String bloco) {
            this.bloco = bloco;
        }
    
        public String getApelido() {
            return apelido;
        }
    
        public void setApelido(String apelido) {
            this.apelido = apelido;
        }
    
        public TipoSala getTipo() {
            return tipo;
        }
    
        public void setTipo(TipoSala tipo) {
            this.tipo = tipo;
        }
    
        public Set<Equipamento> getEquipamentos() {
            return equipamentos;
        }
    
        public void setEquipamentos(Set<Equipamento> equipamentos) {
            this.equipamentos = equipamentos;
        }
}

