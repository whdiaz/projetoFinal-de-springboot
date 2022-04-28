package com.projeto.curosFinalizado.entidad;

import com.projeto.curosFinalizado.entidad.pk.ItemDePedidoPk;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_pedido_item")
public class ItemDePedido implements Serializable {
    private static  final long serialVersionUID = 1L;

    @EmbeddedId
    private ItemDePedidoPk id;

    private Integer quantidade;
    private Double preco;

    public ItemDePedido(){

    }

    public ItemDePedido(Pedido pedido,Produto produto,Integer quantidade, Double preco) {
        super();
        id.setPedido(pedido);
        id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Pedido getPedido(){
        return id.getPedido();
    }

    public void  setPedido(Pedido pedido){
        id.setPedido(pedido);
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public Produto getProduto(){
        return id.getProduto();
    }

    public void  setProduto(Produto produto){
        id.setProduto(produto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemDePedido)) return false;
        ItemDePedido that = (ItemDePedido) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
