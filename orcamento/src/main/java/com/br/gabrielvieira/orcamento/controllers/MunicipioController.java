package com.br.gabrielvieira.orcamento.controllers;


import com.br.gabrielvieira.orcamento.model.Municipio;
import com.br.gabrielvieira.orcamento.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/municipio")
public class MunicipioController {

    @Autowired
    private MunicipioService municipioService;
    public ResponseEntity<Municipio> inseri(@RequestBody Municipio municipio) {
        Municipio municipioSalva = municipioService.salvar(municipio);
        return ResponseEntity.status(HttpStatus.CREATED).body(municipioSalva);
    }
}
