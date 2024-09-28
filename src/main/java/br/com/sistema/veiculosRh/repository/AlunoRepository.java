package br.com.sistema.veiculosRh.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.veiculosRh.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Set<Aluno> findBySalas_Id(Long salaId);
}

