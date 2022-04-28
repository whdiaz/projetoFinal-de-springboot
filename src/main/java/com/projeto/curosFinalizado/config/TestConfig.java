package com.projeto.curosFinalizado.config;

import com.projeto.curosFinalizado.entidad.*;
import com.projeto.curosFinalizado.entidad.enums.StatusDePedido;
import com.projeto.curosFinalizado.repositorios.*;
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

    @Autowired
    private RepositorioDeCategoria repositorioDeCategoria;

    @Autowired
    private RepositorioDeProduto repositorioDeProduto;

    @Autowired
    private RepositorioDeItemDPedidos repositorioDeItemDPedidos;


    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "electronica");
        Categoria cat2 = new Categoria(null, "livros");
        Categoria cat3 = new Categoria(null, "informatica");


        Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");



        repositorioDeCategoria.saveAll(Arrays.asList(cat1,cat2,cat3));
        repositorioDeProduto.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategorias().add(cat2);
        p2.getCategorias().add(cat3);
        p3.getCategorias().add(cat3);
        p4.getCategorias().add(cat3);
        p5.getCategorias().add(cat2);

        repositorioDeProduto.saveAll(Arrays.asList(p1,p2,p3,p4,p5));




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

        ItemDePedido oi1 = new ItemDePedido(o1, p1, 2, p1.getPreco());
        ItemDePedido oi2 = new ItemDePedido(o1, p3, 1, p3.getPreco());
        ItemDePedido oi3 = new ItemDePedido(o2, p3, 2, p3.getPreco());
        ItemDePedido oi4 = new ItemDePedido(o3, p5, 2, p5.getPreco());

        repositorioDeItemDPedidos.saveAll(Arrays.asList(oi1, oi2,oi3,oi4));

    }
}
