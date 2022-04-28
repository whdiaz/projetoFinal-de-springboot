package com.projeto.curosFinalizado.serviços;

import com.projeto.curosFinalizado.entidad.Pedido;
import com.projeto.curosFinalizado.repositorios.RepositorioDePedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicosDePedidos {

    @Autowired
    private RepositorioDePedidos repository;

    public List<Pedido> findAll(){
        return repository.findAll();
    }
    public Pedido findById(Long id){
        Optional<Pedido> obj = repository.findById(id);
        return obj.get();
    }

}
