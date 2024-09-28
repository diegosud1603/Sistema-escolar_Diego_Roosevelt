package br.com.sistema.veiculosRh.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistema.veiculosRh.model.Aluno;
import br.com.sistema.veiculosRh.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Set<Aluno> listarAlunosPorSala(Long salaId) {
        return alunoRepository.findBySalas_Id(salaId);
    }
}

