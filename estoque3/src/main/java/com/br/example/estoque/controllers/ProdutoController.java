package com.br.example.estoque.controllers;


import com.br.example.estoque.model.Categoria;
import com.br.example.estoque.model.Produto;
import com.br.example.estoque.repositories.ProdutoRepository;
import com.br.example.estoque.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping()
    public List<Produto> ListarTodasCategorias(){ return produtoRepository.findAll(Sort.by("nomeproduto").ascending());}

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPeloCodigo(@PathVariable long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return Produto.isPresent() ? ResponseEntity.ok(Produto.get()) : ResponseEntity.notFound() .build();
    }

    @PostMapping()
    public ResponseEntity<Produto> inserirProduto(@RequestBody Produto produto){
        Produto produtoSalvo = produtoService.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }
}
