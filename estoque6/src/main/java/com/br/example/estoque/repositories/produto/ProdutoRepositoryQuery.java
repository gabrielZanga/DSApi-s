package com.br.example.estoque.repositories.produto;

import com.br.example.estoque.dto.ProdutoDto;
import com.br.example.estoque.repositories.filters.ProdutoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoRepositoryQuery {
    public Page<ProdutoDto> filtrar(ProdutoFilter produtoFilter, Pageable pageable);
}
