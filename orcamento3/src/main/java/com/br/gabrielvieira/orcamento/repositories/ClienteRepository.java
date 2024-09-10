package com.br.gabrielvieira.orcamento.repositories;

import com.br.gabrielvieira.orcamento.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
