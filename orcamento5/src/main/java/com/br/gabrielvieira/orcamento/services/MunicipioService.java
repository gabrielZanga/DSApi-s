package com.br.gabrielvieira.orcamento.services;

import com.br.gabrielvieira.orcamento.model.Municipio;
import com.br.gabrielvieira.orcamento.repositories.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository municipioRepository;
    public Municipio salvar (Municipio municipio) { return municipioRepository.save(municipio); }
}
