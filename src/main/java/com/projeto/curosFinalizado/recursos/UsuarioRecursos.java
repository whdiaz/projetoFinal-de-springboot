package com.projeto.curosFinalizado.recursos;

import com.projeto.curosFinalizado.entidad.Usuario;
import com.projeto.curosFinalizado.serviços.ServicosDeUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecursos {

    @Autowired
    private ServicosDeUsuarios servicos;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> list = servicos.findAll();
        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}")
    public  ResponseEntity<Usuario> findById(@PathVariable Long id){
        Usuario obj = servicos.findbyID(id);
        return ResponseEntity.ok().body(obj);

    }

    @PostMapping
    public ResponseEntity<Usuario> inserir( @RequestBody Usuario obj){
        obj = servicos.inserir(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);

    }

    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<Void> apagar(@PathVariable Long id){
        servicos.apagar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value =  "/{id}")
    public  ResponseEntity<Usuario>  atualizar(@PathVariable Long id, @RequestBody Usuario obj){
        obj = servicos.atualizar(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}