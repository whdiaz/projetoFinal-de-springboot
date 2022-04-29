package com.projeto.curosFinalizado.serviços;

import com.projeto.curosFinalizado.entidad.Usuario;
import com.projeto.curosFinalizado.repositorios.RepositorioDeUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicosDeUsuarios {

    @Autowired
    private RepositorioDeUsuario repositorio;
    public List<Usuario>  findAll(){
        return repositorio.findAll();
    }

    public Usuario findbyID(long  id){
       Optional<Usuario> obj = repositorio.findById(id);
       return obj.get();
    }

    public Usuario inserir(Usuario obj){
       return repositorio.save(obj);
    }

    public void apagar(Long id){
        repositorio.deleteById(id);

    }
    public Usuario atualizar(Long id, Usuario obj){
        Usuario entity = repositorio.getById(id);
        atualizarData(entity, obj);
        return repositorio.save(entity);
    }

    private void atualizarData(Usuario entity, Usuario obj) {
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
        entity.setTelefone(obj.getTelefone());
    }


}
