package com.br.gabrielvieira.orcamento.services;

import com.br.gabrielvieira.orcamento.model.Cliente;
import com.br.gabrielvieira.orcamento.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    public Cliente salvar (Cliente cliente){ return clienteRepository.save(cliente); }
}
