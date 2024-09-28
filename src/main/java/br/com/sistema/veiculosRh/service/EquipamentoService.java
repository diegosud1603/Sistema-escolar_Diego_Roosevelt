package br.com.sistema.veiculosRh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistema.veiculosRh.model.Equipamento;
import br.com.sistema.veiculosRh.repository.EquipamentoRepository;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public List<Equipamento> listarEquipamentosPorSala(Long salaId) {
        return equipamentoRepository.findBySala_Id(salaId);
    }
    
    public List<Equipamento> listarEquipamentosLigados() {
        return equipamentoRepository.findEquipamentosLigados();
    }
    
    public Equipamento alterarSituacao(String numeroPatrimonio, String novaSituacao) {
        Equipamento equipamento = equipamentoRepository.findByNumeroPatrimonio(numeroPatrimonio);

        if (equipamento == null) {
            throw new RuntimeException("Equipamento não encontrado com o número de patrimônio: " + numeroPatrimonio);
        }

        equipamento.setSituacaoFromString(novaSituacao);
        return equipamentoRepository.save(equipamento);
    }

    public Equipamento criarEquipamento(Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    public Equipamento obterEquipamento(Long id) {
        return equipamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado com ID: " + id));
    }

    public List<Equipamento> listarEquipamentos() {
        return equipamentoRepository.findAll();
    }

    public Equipamento atualizarEquipamento(Long id, Equipamento equipamentoAtualizado) {
        Equipamento equipamentoExistente = obterEquipamento(id);
        equipamentoExistente.setNome(equipamentoAtualizado.getNome());
        equipamentoExistente.setNumeroPatrimonio(equipamentoAtualizado.getNumeroPatrimonio());
        equipamentoExistente.setAnoAquisicao(equipamentoAtualizado.getAnoAquisicao());
        equipamentoExistente.setDescricao(equipamentoAtualizado.getDescricao());
        equipamentoExistente.setSituacao(equipamentoAtualizado.getSituacao());

        return equipamentoRepository.save(equipamentoExistente);
    }

    public void excluirEquipamento(Long id) {
        Equipamento equipamentoExistente = obterEquipamento(id);
        equipamentoRepository.delete(equipamentoExistente);
    }
}

