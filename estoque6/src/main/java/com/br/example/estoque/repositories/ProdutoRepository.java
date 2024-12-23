package com.br.example.estoque.repositories;

import com.br.example.estoque.model.Produto;
import com.br.example.estoque.repositories.produto.ProdutoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>, ProdutoRepositoryQuery {
}
