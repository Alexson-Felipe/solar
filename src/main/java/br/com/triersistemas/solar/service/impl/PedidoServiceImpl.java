package br.com.triersistemas.solar.service.impl;

import br.com.triersistemas.solar.controller.ClienteController;
import br.com.triersistemas.solar.controller.FarmaceuticoController;
import br.com.triersistemas.solar.domain.Pedido;
import br.com.triersistemas.solar.exceptions.NaoExisteException;
import br.com.triersistemas.solar.model.AdicionarPedidoModel;
import br.com.triersistemas.solar.model.PagarPedidoModel;
import br.com.triersistemas.solar.model.PedidoModel;
import br.com.triersistemas.solar.repository.PedidoRepository;
import br.com.triersistemas.solar.service.PedidoService;
import br.com.triersistemas.solar.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;


    @Autowired
    private PedidoService pedidoService;


    @Override
    public List<Pedido> consultar() {
        return pedidoRepository.consultar();
    }

    @Override
    public Pedido consultar(UUID id) {
        return pedidoRepository.consultar(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Pedido cadastrar(PedidoModel model) {

        var farmaceutico = FarmaceuticoController.LIST.stream()
                .filter(f -> f.getId().equals(model.getIdFarmaceutico()))
                .findFirst()
                .orElseThrow(NaoExisteException::new);

        var cliente = ClienteController.LIST.stream()
                .filter(f -> f.getId().equals(model.getIdCliente()))
                .findFirst()
                .orElseThrow(NaoExisteException::new);

        Pedido pedido = new Pedido(farmaceutico, cliente);
        pedidoRepository.cadastrar(pedido);
        return pedido;
    }

    @Override
    public Pedido adicionarProdutos(UUID id, AdicionarPedidoModel model) {
        var pedido = pedidoRepository.consultar(id)
                .orElseThrow(NaoExisteException::new);

        var produtos = pedidoService.consultar(model.getIdProdutos())



        var produtos = model.getIdProdutos()
                .stream()
                .map(idProduto -> {
                    return produtoService.consultar(idProduto);
                }).collect(Collectors.toList());

        return pedido.adicionarProdutos(produtos);
    }

    @Override
    public Pedido pagar(UUID id, PagarPedidoModel model) {
        var pedido = pedidoRepository.consultar(id)
                .orElseThrow(NaoExisteException::new);
        return pedido.pagar(model.getValor());
    }
}
