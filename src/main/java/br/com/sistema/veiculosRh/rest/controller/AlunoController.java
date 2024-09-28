package br.com.sistema.veiculosRh.rest.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.veiculosRh.model.Aluno;
import br.com.sistema.veiculosRh.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/sala/{salaId}")
    public Set<Aluno> listarAlunosPorSala(@PathVariable Long salaId) {
        return alunoService.listarAlunosPorSala(salaId);
    }
}

