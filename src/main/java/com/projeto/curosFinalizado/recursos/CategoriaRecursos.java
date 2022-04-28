package com.projeto.curosFinalizado.recursos;

import com.projeto.curosFinalizado.entidad.Categoria;
import com.projeto.curosFinalizado.entidad.Usuario;
import com.projeto.curosFinalizado.serviços.ServicosDeCategoria;
import com.projeto.curosFinalizado.serviços.ServicosDeUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRecursos {

    @Autowired
    private ServicosDeCategoria servicos;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> list = servicos.findAll();
        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}")
    public  ResponseEntity<Categoria> findById(@PathVariable Long id){
        Categoria obj = servicos.findById(id);
        return ResponseEntity.ok().body(obj);

    }
}