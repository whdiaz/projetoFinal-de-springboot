package com.projeto.curosFinalizado.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.curosFinalizado.entidad.enums.StatusDePedido;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pedido  implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern =  "yyyy-MM-dd'T'HH:mm:ss'Z' ", timezone = "GMT")
    private Instant moment;

    private Integer statusDePedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemDePedido>  items = new HashSet<>();

    public  Pedido(){

    }

    public Pedido(Long id, Instant moment,StatusDePedido statusDePedido,  Usuario cliente) {
        this.id = id;
        this.moment = moment;
        setStatusDePedido(statusDePedido);
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public StatusDePedido getStatusDePedido() {
        return StatusDePedido.valueOf( statusDePedido);
    }

    public void setStatusDePedido(StatusDePedido statusDePedido) {
        if ( statusDePedido != null) {
            this.statusDePedido = statusDePedido.getCodigo();
        }
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Set<ItemDePedido> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return id.equals(pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
