package com.br.example.estoque.repositories.categoria;

import com.br.example.estoque.model.Categoria;
import com.br.example.estoque.repositories.CategoriaRepository;
import com.br.example.estoque.repositories.filters.CategoriaFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositoryImpl implements CategoriaRepositoryQuery {
    @PersistenceContext
    private EntityManager manager;
    @Override
    public Page<Categoria> filtrar(CategoriaFilter categoriaFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Categoria> criteria = builder.createQuery(Categoria.class);
        Root<Categoria> root = criteria.from(Categoria.class);

        Predicate[] predicates = criarRestricoes(categoriaFilter,builder,root);

        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nome")));
        TypedQuery<Categoria> query manager.createQuery(criteria);

        return null;
    }

    private Predicate[] criarRestricoes(CategoriaFilter categoriaFilter, CriteriaBuilder builder, Root<Categoria> root) {
        List<Predicate> predicates = new ArrayList<>();
        if (!StringUtils.isEmpty(categoriaFilter.getNome())){
            predicates.add(builder.like(builder.lower(root.get("nome")), "%" +categoriaFilter.getNome().toLowerCase()+"%"));
        }
        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
