package br.com.triersistemas.solar.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class ItemPedido {

    private UUID id;
    private Produto produto;
    private Integer quantidade;
    private BigDecimal valor;

    public ItemPedido(Produto produto, Integer quantidade, BigDecimal valor) {
        this.id = UUID.randomUUID();
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = produto.getValor().multiply(BigDecimal.valueOf(quantidade));
    }

}
