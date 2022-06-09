package br.com.triersistemas.solar.model;

import br.com.triersistemas.solar.domain.Produto;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ItemPedidoModel {

    private Produto produto;
    private Integer quantidade;
    private BigDecimal valor;

}
