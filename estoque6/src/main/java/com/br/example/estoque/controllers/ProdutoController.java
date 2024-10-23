package com.br.example.estoque.controllers;


import com.br.example.estoque.dto.ProdutoDto;
import com.br.example.estoque.model.Categoria;
import com.br.example.estoque.model.Produto;
import com.br.example.estoque.repositories.ProdutoRepository;
import com.br.example.estoque.repositories.filters.ProdutoFilter;
import com.br.example.estoque.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ProdutoRepository produtoRepository;

    public Page<ProdutoDto> pesquisar(ProdutoFilter produtoFilter, Pageable pageable) {
        return produtoRepository.filtrar(produtoFilter, pageable);
    }
    @GetMapping("/todos")
    public List<Produto> ListarTodasCategorias(){ return produtoRepository.findAll(Sort.by("nomeproduto").ascending());}

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPeloCodigo(@PathVariable Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.isPresent() ? ResponseEntity.ok(produto.get()) : ResponseEntity.notFound() .build();
    }

    @PostMapping()
    public ResponseEntity<Produto> inserirProduto(@RequestBody Produto produto){
        Produto produtoSalvo = produtoService.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) { produtoRepository.deleteById(id); }
}
