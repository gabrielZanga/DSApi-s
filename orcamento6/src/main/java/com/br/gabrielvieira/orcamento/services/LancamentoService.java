package com.br.gabrielvieira.orcamento.services;


import com.br.gabrielvieira.orcamento.model.Lancamento;
import com.br.gabrielvieira.orcamento.repositories.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;
    public Lancamento salvar (Lancamento lancamento) { return lancamentoRepository.save(lancamento); }
}
