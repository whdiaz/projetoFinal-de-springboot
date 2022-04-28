package com.projeto.curosFinalizado.entidad.enums;

public enum StatusDePedido {

    ESPERANDO_PAGAMENTO(1),
    PAGO(2),
    ENVIADO(3),
    ENTREGUE(4),
    CANCELADO(5);

    private int codigo;

    private  StatusDePedido(int codigo){
        this.codigo = codigo;
    }
    public  int getCodigo(){
        return codigo;
    }

    public static StatusDePedido valueOf(int codigo){
        for (StatusDePedido value : StatusDePedido.values()){
            if (value.getCodigo() == codigo){
                return value;
            }
        }
        throw new IllegalArgumentException("codigo de status de pedido envalido");
    }

}
