package com.br.example.estoque.repositories;

import com.br.example.estoque.model.Categoria;
import com.br.example.estoque.repositories.categoria.CategoriaRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>, CategoriaRepositoryQuery {
}
