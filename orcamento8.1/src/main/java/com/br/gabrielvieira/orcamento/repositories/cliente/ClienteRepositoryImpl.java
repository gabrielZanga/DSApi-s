package com.br.gabrielvieira.orcamento.repositories.cliente;

import com.br.gabrielvieira.orcamento.model.Cliente;
import com.br.gabrielvieira.orcamento.repositories.filters.ClienteFilter;
import com.br.gabrielvieira.orcamento.repositories.filters.MunicipioFilter;
import com.br.gabrielvieira.orcamento.repositories.municipio.MunicipioRepositoryQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepositoryQuery{
    @PersistenceContext
    private EntityManager manager;
    @Override
    public Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
        Root<Cliente> root = criteria.from(Cliente.class);

        Predicate[] predicates = criarRestricoes(clienteFilter,builder,root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nome")));

        TypedQuery<Cliente> query = manager.createQuery(criteria);
        adicionarRestricoesPaginacao(query, pageable);
        return  new PageImpl<>(query.getResultList(), pageable, total(clienteFilter));
    }

    private long total(ClienteFilter clienteFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Cliente> root = criteria.from(Cliente.class);

        Predicate[] predicates = criarRestricoes(clienteFilter,builder,root);
        criteria.where(predicates);

        criteria.select(builder.count(root));
        return manager.createQuery(criteria).getSingleResult();
    }

    private void adicionarRestricoesPaginacao(TypedQuery<Cliente> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalResgistrosPorPagina = pageable.getPageSize();
        int primeiroResgistroDaPagina = paginaAtual * totalResgistrosPorPagina;

        query.setFirstResult(primeiroResgistroDaPagina);
        query.setMaxResults(totalResgistrosPorPagina);
    }

    private Predicate[] criarRestricoes(ClienteFilter clienteFilter, CriteriaBuilder builder, Root<Cliente> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(clienteFilter.getNome())){
            predicates.add(builder.like(builder.lower(root.get("nome")),"%" +clienteFilter.getNome().toLowerCase()+"%"));
        }
        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
