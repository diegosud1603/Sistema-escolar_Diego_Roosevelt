package br.com.sistema.veiculosRh.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistema.veiculosRh.model.Pessoa;
import br.com.sistema.veiculosRh.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listarTodasPessoas() {
        return pessoaRepository.findAll();
    }

    public Map<String, Long> contarPessoasPorTipo() {
        Map<String, Long> contagem = new HashMap<>();

        contagem.put("Visitante", pessoaRepository.countByTipo("Visitante"));
        contagem.put("Aluno", pessoaRepository.countByTipo("Aluno"));
        contagem.put("ProfessorTeorico", pessoaRepository.countByTipo("ProfessorTeorico"));
        contagem.put("ProfessorPratico", pessoaRepository.countByTipo("ProfessorPratico"));

        return contagem;
    }

    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa obterPessoa(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com ID: " + id));
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa atualizarPessoa(Long id, Pessoa pessoaAtualizada) {
        Pessoa pessoaExistente = obterPessoa(id);
        pessoaExistente.setNome(pessoaAtualizada.getNome());
        pessoaExistente.setCpf(pessoaAtualizada.getCpf());
        // Atualizar outros campos, se necessário
        return pessoaRepository.save(pessoaExistente);
    }

    public void excluirPessoa(Long id) {
        Pessoa pessoaExistente = obterPessoa(id);
        pessoaRepository.delete(pessoaExistente);
    }

    public Pessoa buscarPessoaPorCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }
}

