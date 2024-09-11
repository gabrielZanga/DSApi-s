package com.br.example.estoque.repositories.categoria;

import com.br.example.estoque.model.Categoria;
import com.br.example.estoque.repositories.CategoriaRepository;
import com.br.example.estoque.repositories.filters.CategoriaFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CategoriaRepositoryImpl implements CategoriaRepositoryQuery {
    @PersistenceContext
    private EntityManager manager;
    @Override
    public Page<Categoria> filtrar(CategoriaFilter categoriaFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Categoria> criteria = builder.createQuery(Categoria.class);
        Root<Categoria> root = criteria.from(Categoria.class);
        return null;
    }
}
