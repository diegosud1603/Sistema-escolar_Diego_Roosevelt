package br.com.sistema.veiculosRh.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistema.veiculosRh.model.Pessoa;
import br.com.sistema.veiculosRh.model.Registro;
import br.com.sistema.veiculosRh.model.Sala;
import br.com.sistema.veiculosRh.model.TipoRegistro;
import br.com.sistema.veiculosRh.repository.RegistroRepository;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository registroRepository;

    public void registrarEntrada(Pessoa pessoa, Sala sala) {
        Registro registro = new Registro();
        registro.setPessoa(pessoa);
        registro.setSala(sala);
        registro.setTipoRegistro(TipoRegistro.ENTRADA);
        registro.setDataHora(LocalDateTime.now());

        registroRepository.save(registro);
    }

    public void registrarSaida(Pessoa pessoa, Sala sala) {
        Registro registro = new Registro();
        registro.setPessoa(pessoa);
        registro.setSala(sala);
        registro.setTipoRegistro(TipoRegistro.SAIDA);
        registro.setDataHora(LocalDateTime.now());

        registroRepository.save(registro);
    }
}

