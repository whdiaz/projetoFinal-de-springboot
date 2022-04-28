package com.projeto.curosFinalizado.serviços;

import com.projeto.curosFinalizado.entidad.Categoria;
import com.projeto.curosFinalizado.entidad.Pedido;
import com.projeto.curosFinalizado.repositorios.RepositorioDeCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicosDeCategoria {

    @Autowired
    private RepositorioDeCategoria repository;

    public List<Categoria> findAll(){
        return repository.findAll();
    }
    public Categoria findById(Long id){
        Optional<Categoria> obj = repository.findById(id);
        return obj.get();
    }

}
