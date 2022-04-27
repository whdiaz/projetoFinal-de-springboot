package com.projeto.curosFinalizado.config;

import com.projeto.curosFinalizado.entidad.Usuario;
import com.projeto.curosFinalizado.repositorios.RepositorioDeUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private RepositorioDeUsuario repositorioDeUsuario;


    @Override
    public void run(String... args) throws Exception {

        Usuario u1 = new Usuario(null, "willian diaz",
                "whdiazsdfws@gmail.com",
                "857462938745", "123456");

        Usuario u2 = new Usuario(null, "soraya charls",
                "sorayacharls@gmail.com",
                "83465737523", "654321");

        repositorioDeUsuario.saveAll(Arrays.asList(u1,u2));
    }
}
