package com.br.gabrielvieira.orcamento.repositories.cliente;

import com.br.gabrielvieira.orcamento.model.Cliente;
import com.br.gabrielvieira.orcamento.repositories.filters.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryQuery {
    public Page<Cliente> filtar(ClienteFilter clienteFilter, Pageable pageable);
}
