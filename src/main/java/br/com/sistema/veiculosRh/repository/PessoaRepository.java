package br.com.sistema.veiculosRh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.veiculosRh.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findAll();
    
    long countByTipo(String tipo);

    Pessoa findByCpf(String cpf);
}

