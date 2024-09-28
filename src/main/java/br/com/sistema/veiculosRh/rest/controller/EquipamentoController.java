package br.com.sistema.veiculosRh.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.veiculosRh.model.Equipamento;
import br.com.sistema.veiculosRh.service.EquipamentoService;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @GetMapping("/sala/{salaId}")
    public List<Equipamento> listarEquipamentosPorSala(@PathVariable Long salaId) {
        return equipamentoService.listarEquipamentosPorSala(salaId);
    }

    @GetMapping("/ligados")
    public List<Equipamento> listarEquipamentosLigados() {
        return equipamentoService.listarEquipamentosLigados();
    }

        @PatchMapping("/situacao/{numeroPatrimonio}")
    public ResponseEntity<Equipamento> alterarSituacao(
            @PathVariable String numeroPatrimonio,
            @RequestParam String novaSituacao) {

        Equipamento equipamentoAtualizado = equipamentoService.alterarSituacao(numeroPatrimonio, novaSituacao);

        return ResponseEntity.ok(equipamentoAtualizado);
    }
    
    @PostMapping
    public ResponseEntity<Equipamento> criarEquipamento(@RequestBody Equipamento equipamento) {
        Equipamento equipamentoCriado = equipamentoService.criarEquipamento(equipamento);
        return ResponseEntity.status(201).body(equipamentoCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipamento> obterEquipamento(@PathVariable Long id) {
        Equipamento equipamento = equipamentoService.obterEquipamento(id);
        return ResponseEntity.ok(equipamento);
    }

    @GetMapping
    public ResponseEntity<List<Equipamento>> listarEquipamentos() {
        List<Equipamento> equipamentos = equipamentoService.listarEquipamentos();
        return ResponseEntity.ok(equipamentos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipamento> atualizarEquipamento(
            @PathVariable Long id,
            @RequestBody Equipamento equipamentoAtualizado) {

        Equipamento equipamento = equipamentoService.atualizarEquipamento(id, equipamentoAtualizado);
        return ResponseEntity.ok(equipamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEquipamento(@PathVariable Long id) {
        equipamentoService.excluirEquipamento(id);
        return ResponseEntity.noContent().build();
    }
}
