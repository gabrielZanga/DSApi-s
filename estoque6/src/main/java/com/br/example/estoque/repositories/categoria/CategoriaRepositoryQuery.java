package com.br.example.estoque.repositories.categoria;

import com.br.example.estoque.model.Categoria;
import com.br.example.estoque.repositories.filters.CategoriaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoriaRepositoryQuery {
    public Page<Categoria> filtrar(CategoriaFilter categoriaFilter, Pageable pageable);
}
