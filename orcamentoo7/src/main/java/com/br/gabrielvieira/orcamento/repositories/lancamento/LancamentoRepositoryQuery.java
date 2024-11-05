package com.br.gabrielvieira.orcamento.repositories.lancamento;

import com.br.gabrielvieira.orcamento.model.Lancamento;
import com.br.gabrielvieira.orcamento.repositories.filters.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentoRepositoryQuery {
    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
}
