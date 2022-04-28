package com.projeto.curosFinalizado.serviços;

import com.projeto.curosFinalizado.entidad.Categoria;
import com.projeto.curosFinalizado.entidad.Produto;
import com.projeto.curosFinalizado.repositorios.RepositorioDeCategoria;
import com.projeto.curosFinalizado.repositorios.RepositorioDeProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicosDeProduto {

    @Autowired
    private RepositorioDeProduto repository;

    public List<Produto> findAll(){
        return repository.findAll();
    }
    public Produto findById(Long id){
        Optional<Produto> obj = repository.findById(id);
        return obj.get();
    }

}
