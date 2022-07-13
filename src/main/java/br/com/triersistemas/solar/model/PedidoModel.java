package br.com.triersistemas.solar.model;

import br.com.triersistemas.solar.domain.Pedido;
import br.com.triersistemas.solar.domain.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class PedidoModel {

    private UUID id;
    private UUID idFarmaceutico;
    private String nomeFarmaceutico;
    private UUID idCliente;
    private String nomeCliente;
    private List<ProdutoModel> produtos;

    //private Farmaceutico farmaceutico;
   // private Cliente cliente;
    private BigDecimal valor;
    private BigDecimal valorPago;
    private BigDecimal troco;

    private LocalDateTime dataEmissao;
    //private LocalDateTime dataPagamento;
    //private LocalDateTime dataCancelamento;
    private String status;

    public PedidoModel(Pedido pedido) {
        this.id = pedido.getId();
        this.idFarmaceutico = pedido.getFarmaceutico().getId();
        this.nomeFarmaceutico = pedido.getFarmaceutico().getNome();
        this.idCliente = pedido.getCliente().getId();
        this.nomeCliente = pedido.getCliente().getNome();
        this.produtos = criarListaProdutos(pedido.getProdutos());
        this.valor = pedido.getValor();
        this.valorPago = pedido.getValorPago();
        this.troco = pedido.getTroco();
        this.dataEmissao = pedido.getDataEmissao();
        //this.dataPagamento = pedido.getDataPagamento();
       // this.dataCancelamento = pedido.getDataCancelamento();
        this.status = pedido.getStatus().name();
       // this.cliente = pedido.getCliente();
        //this.farmaceutico = pedido.getFarmaceutico();
    }

    private List<ProdutoModel> criarListaProdutos(List<Produto> produtos){
        if(Objects.nonNull(produtos) && !produtos.isEmpty() ){
            return  produtos.stream().map(ProdutoModel::new).toList();
        }else{
            return new ArrayList<>();
        }
    }
}
