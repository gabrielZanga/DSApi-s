package com.br.gabrielvieira.orcamento.repositories.municipio;

import com.br.gabrielvieira.orcamento.model.Municipio;
import com.br.gabrielvieira.orcamento.repositories.filters.MunicipioFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface MunicipioRepositoryQuery {
    public Page<Municipio> filtrar(MunicipioFilter municipioFilter, Pageable pageable);
}
