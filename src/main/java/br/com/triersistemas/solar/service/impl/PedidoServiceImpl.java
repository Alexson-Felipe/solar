package br.com.triersistemas.solar.service.impl;

import br.com.triersistemas.solar.domain.Pedido;
import br.com.triersistemas.solar.domain.Produto;
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

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ProdutoServiceImpl produtoServiceImpl;
    @Autowired
    private FarmaceuticoServiceImpl farmaceuticoServiceImpl;
    @Autowired
    private ClienteServiceImpl clienteServiceImpl;


    @Override
    public List<PedidoModel> consultar() {
        return pedidoRepository.findAll().stream().map(PedidoModel::new).toList();
    }

    @Override
    public PedidoModel consultar(UUID id) {
        return new PedidoModel(this.buscarPorId(id));
    }


    @Override
    public PedidoModel cadastrar(PedidoModel model) {

        var farmaceutico = farmaceuticoServiceImpl.consultarFarmaceuticoId(model.getIdFarmaceutico());

        var cliente = clienteServiceImpl.consultarClienteId(model.getIdCliente());

        Pedido pedido = new Pedido(farmaceutico, cliente);
        return new PedidoModel(pedidoRepository.save(pedido));
    }

    @Override
    public PedidoModel adicionarProdutos(UUID id, AdicionarPedidoModel model) {
        var pedido = this.buscarPorId(id);
        List<Produto> produtos = produtoServiceImpl.consultarProdutos(model.getIdProdutos());


        return new PedidoModel(pedidoRepository.save(pedido.adicionarProdutos(produtos)));
    }

    @Override
    public PedidoModel pagar(UUID id, PagarPedidoModel model) {
        var pedido = this.buscarPorId(id);
        pedido.pagar(model.getValor());
        return new PedidoModel(pedido);
    }

    private Pedido buscarPorId(UUID id) {
        return pedidoRepository
                .findById(id)
                .orElseThrow(NaoExisteException::new);
    }
}
