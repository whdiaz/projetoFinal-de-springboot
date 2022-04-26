package com.projeto.curosFinalizado.recursos;

import com.projeto.curosFinalizado.entidad.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecursos {

    @GetMapping
    public ResponseEntity<Usuario> findAll() {
        Usuario u = new Usuario(1L, "chemberlay",
                "chemberlay@gmail.com", "1345643090", "12345");
        return ResponseEntity.ok().body(u);

    }
}