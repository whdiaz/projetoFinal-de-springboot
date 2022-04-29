package com.projeto.curosFinalizado.serviços;

import com.projeto.curosFinalizado.entidad.Usuario;
import com.projeto.curosFinalizado.repositorios.RepositorioDeUsuario;
import com.projeto.curosFinalizado.serviços.exceptions.DataBaseException;
import com.projeto.curosFinalizado.serviços.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
       return obj.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public Usuario inserir(Usuario obj){
       return repositorio.save(obj);
    }

    public void apagar(Long id){
        try {
            repositorio.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new   ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw  new DataBaseException(e.getMessage());

        }

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
