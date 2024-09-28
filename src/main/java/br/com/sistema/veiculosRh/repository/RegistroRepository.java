package br.com.sistema.veiculosRh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.veiculosRh.model.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {
    // Aqui você pode adicionar métodos personalizados se necessário
}

