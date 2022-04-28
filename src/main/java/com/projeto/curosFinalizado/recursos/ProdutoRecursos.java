package com.projeto.curosFinalizado.recursos;

import com.projeto.curosFinalizado.entidad.Produto;
import com.projeto.curosFinalizado.entidad.Usuario;
import com.projeto.curosFinalizado.serviços.ServicosDeProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoRecursos {

    @Autowired
    private ServicosDeProduto servicos;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> list = servicos.findAll();
        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}")
    public  ResponseEntity<Produto> findById(@PathVariable Long id){
        Produto obj = servicos.findById(id);
        return ResponseEntity.ok().body(obj);

    }
}