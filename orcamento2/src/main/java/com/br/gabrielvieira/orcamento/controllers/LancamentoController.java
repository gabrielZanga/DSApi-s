package com.br.gabrielvieira.orcamento.controllers;


import com.br.gabrielvieira.orcamento.model.Lancamento;
import com.br.gabrielvieira.orcamento.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lancamento")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;
    @PostMapping()
    public ResponseEntity<Lancamento> inserir(@RequestBody Lancamento lancamento) {
        Lancamento lancamentoSalva = lancamentoService.salvar(lancamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalva);
    }
}
