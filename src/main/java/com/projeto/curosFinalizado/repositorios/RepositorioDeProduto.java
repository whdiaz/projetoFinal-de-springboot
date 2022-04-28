package com.projeto.curosFinalizado.repositorios;

import com.projeto.curosFinalizado.entidad.Categoria;
import com.projeto.curosFinalizado.entidad.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioDeProduto extends JpaRepository<Produto, Long> {



}
