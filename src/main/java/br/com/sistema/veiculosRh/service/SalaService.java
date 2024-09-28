package br.com.sistema.veiculosRh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistema.veiculosRh.model.Equipamento;
import br.com.sistema.veiculosRh.model.Sala;
import br.com.sistema.veiculosRh.repository.EquipamentoRepository;
import br.com.sistema.veiculosRh.repository.SalaRepository;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public Sala adicionarEquipamento(Long salaId, Equipamento equipamento) {
        Sala sala = salaRepository.findById(salaId)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada com ID: " + salaId));

        equipamento.setSala(sala);
        sala.getEquipamentos().add(equipamento);

        return salaRepository.save(sala);
    }

    public Sala removerEquipamento(Long salaId, Long equipamentoId) {
        Sala sala = salaRepository.findById(salaId)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada com ID: " + salaId));

        Equipamento equipamento = equipamentoRepository.findById(equipamentoId)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado com ID: " + equipamentoId));

        sala.getEquipamentos().remove(equipamento);
        equipamento.setSala(null); // Desvincula o equipamento da sala

        equipamentoRepository.delete(equipamento); // Opcional: Remove o equipamento do repositório

        return salaRepository.save(sala);
    }

    public Sala criarSala(Sala sala) {
        return salaRepository.save(sala);
    }

    public Sala obterSala(Long id) {
        return salaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada com ID: " + id));
    }

    public List<Sala> listarSalas() {
        return salaRepository.findAll();
    }

    public Sala atualizarSala(Long id, Sala salaAtualizada) {
        Sala salaExistente = obterSala(id);
        salaExistente.setNumero(salaAtualizada.getNumero());
        salaExistente.setBloco(salaAtualizada.getBloco());
        salaExistente.setApelido(salaAtualizada.getApelido());

        return salaRepository.save(salaExistente);
    }

    public void excluirSala(Long id) {
        Sala salaExistente = obterSala(id);
        salaRepository.delete(salaExistente);
    }
}
