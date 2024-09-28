package br.com.sistema.veiculosRh.rest.controller;

import java.util.List;

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

import br.com.sistema.veiculosRh.model.Equipamento;
import br.com.sistema.veiculosRh.model.Sala;
import br.com.sistema.veiculosRh.service.SalaService;

@RestController
@RequestMapping("/salas")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @PostMapping("/{salaId}/equipamentos")
    public ResponseEntity<Sala> adicionarEquipamento(
            @PathVariable Long salaId,
            @RequestBody Equipamento equipamento) {

        Sala salaAtualizada = salaService.adicionarEquipamento(salaId, equipamento);
        return ResponseEntity.ok(salaAtualizada);
    }

    @DeleteMapping("/{salaId}/equipamentos/{equipamentoId}")
    public ResponseEntity<Sala> removerEquipamento(
            @PathVariable Long salaId,
            @PathVariable Long equipamentoId) {

        Sala salaAtualizada = salaService.removerEquipamento(salaId, equipamentoId);
        return ResponseEntity.ok(salaAtualizada);
    }

        @PostMapping
    public ResponseEntity<Sala> criarSala(@RequestBody Sala sala) {
        Sala salaCriada = salaService.criarSala(sala);
        return ResponseEntity.status(201).body(salaCriada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> obterSala(@PathVariable Long id) {
        Sala sala = salaService.obterSala(id);
        return ResponseEntity.ok(sala);
    }

    @GetMapping
    public ResponseEntity<List<Sala>> listarSalas() {
        List<Sala> salas = salaService.listarSalas();
        return ResponseEntity.ok(salas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sala> atualizarSala(
            @PathVariable Long id,
            @RequestBody Sala salaAtualizada) {

        Sala sala = salaService.atualizarSala(id, salaAtualizada);
        return ResponseEntity.ok(sala);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirSala(@PathVariable Long id) {
        salaService.excluirSala(id);
        return ResponseEntity.noContent().build();
    }
}
