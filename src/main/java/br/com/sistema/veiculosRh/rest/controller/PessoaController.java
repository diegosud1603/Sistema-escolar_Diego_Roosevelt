package br.com.sistema.veiculosRh.rest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.veiculosRh.model.Pessoa;
import br.com.sistema.veiculosRh.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/listar")
    public List<Pessoa> listarTodasPessoas() {
        return pessoaService.listarTodasPessoas();
    }

    @GetMapping("/contagemPorTipo")
    public Map<String, Long> contarPessoasPorTipo() {
        return pessoaService.contarPessoasPorTipo();
    }

        @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa pessoaCriada = pessoaService.criarPessoa(pessoa);
        return ResponseEntity.status(201).body(pessoaCriada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> obterPessoa(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.obterPessoa(id);
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        List<Pessoa> pessoas = pessoaService.listarPessoas();
        return ResponseEntity.ok(pessoas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(
            @PathVariable Long id,
            @RequestBody Pessoa pessoaAtualizada) {

        Pessoa pessoa = pessoaService.atualizarPessoa(id, pessoaAtualizada);
        return ResponseEntity.ok(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPessoa(@PathVariable Long id) {
        pessoaService.excluirPessoa(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Pessoa> buscarPessoaPorCpf(@PathVariable String cpf) {
        Pessoa pessoa = pessoaService.buscarPessoaPorCpf(cpf);
        return ResponseEntity.ok(pessoa);
    }
}

