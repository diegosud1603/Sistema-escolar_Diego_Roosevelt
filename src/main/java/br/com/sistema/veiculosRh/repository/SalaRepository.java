package br.com.sistema.veiculosRh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.veiculosRh.model.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

    // Método para encontrar sala por número
    Sala findByNumero(String numero);
}

