package com.projeto.curosFinalizado.recursos;

import com.projeto.curosFinalizado.entidad.Usuario;
import com.projeto.curosFinalizado.serviços.ServicosDeUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}