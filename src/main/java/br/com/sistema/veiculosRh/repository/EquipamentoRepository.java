package br.com.sistema.veiculosRh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sistema.veiculosRh.model.Equipamento;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
    List<Equipamento> findBySala_Id(Long salaId);
    @Query("SELECT e FROM Equipamento e WHERE e.situacao = 'LIGADO'")
    List<Equipamento> findEquipamentosLigados();

    Equipamento findByNumeroPatrimonio(String numeroPatrimonio);
}

