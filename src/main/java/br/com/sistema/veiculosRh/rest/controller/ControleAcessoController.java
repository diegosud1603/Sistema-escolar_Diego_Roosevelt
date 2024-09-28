package br.com.sistema.veiculosRh.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.veiculosRh.model.RegistroRequest;
import br.com.sistema.veiculosRh.service.RegistroService;

@RestController
@RequestMapping("/ControleAcesso")
public class ControleAcessoController {

    @Autowired
    private RegistroService registroService;

    @PostMapping("/registrarEntrada")
    public void registrarEntrada(@RequestBody RegistroRequest request) {
        // Validar a pessoa e a sala antes de registrar
        registroService.registrarEntrada(request.getPessoa(), request.getSala());
    }

    @PostMapping("/registrarSaida")
    public void registrarSaida(@RequestBody RegistroRequest request) {
        // Validar a pessoa e a sala antes de registrar
        registroService.registrarSaida(request.getPessoa(), request.getSala());
    }
}

