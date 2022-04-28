package com.projeto.curosFinalizado.config;

import com.projeto.curosFinalizado.entidad.Pedido;
import com.projeto.curosFinalizado.entidad.Usuario;
import com.projeto.curosFinalizado.entidad.enums.StatusDePedido;
import com.projeto.curosFinalizado.repositorios.RepositorioDePedidos;
import com.projeto.curosFinalizado.repositorios.RepositorioDeUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private RepositorioDeUsuario repositorioDeUsuario;

    @Autowired
    private RepositorioDePedidos repositorioDePedidos;


    @Override
    public void run(String... args) throws Exception {

        Usuario u1 = new Usuario(null, "willian diaz",
                "whdiazsdfws@gmail.com",
                "857462938745", "123456");

        Usuario u2 = new Usuario(null, "soraya charls",
                "sorayacharls@gmail.com",
                "83465737523", "654321");

        Pedido o1 = new Pedido(null, Instant.parse("2022-06-20T19:53:07Z"), StatusDePedido.PAGO, u1);
        Pedido o2 = new Pedido(null, Instant.parse("2022-07-21T03:42:10Z"), StatusDePedido.ESPERANDO_PAGAMENTO,u2);
        Pedido o3 = new Pedido(null, Instant.parse("2022-07-22T15:21:22Z"), StatusDePedido.ENVIADO,u1);

        repositorioDeUsuario.saveAll(Arrays.asList(u1,u2));
        repositorioDePedidos.saveAll(Arrays.asList(o1,o2,o3));
    }
}
