package br.com.triersistemas.solar.service.impl;

import br.com.triersistemas.solar.domain.Cliente;
import br.com.triersistemas.solar.domain.Produto;
import br.com.triersistemas.solar.exceptions.NaoExisteException;
import br.com.triersistemas.solar.model.ProdutoModel;
import br.com.triersistemas.solar.repository.ProdutoRepository;
import br.com.triersistemas.solar.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<ProdutoModel> consultar() {
        return produtoRepository.findAll().stream().map(ProdutoModel::new).toList();
    }

    @Override
    public ProdutoModel consultar(UUID id) {
        return new ProdutoModel(this.buscarProdutoId(id));
    }

    @Override
    public ProdutoModel consultar(List<UUID> idProdutos) {
        var idP = idProdutos.stream().filter(p -> p.equals(produtoRepository.findAll())).findFirst().orElseThrow(NaoExisteException::new);
        return new ProdutoModel(this.buscarProdutoId(idP));

    }

    @Override
    public ProdutoModel cadastrar(ProdutoModel model) {
        Produto produto = new Produto(model);
        return new ProdutoModel(produtoRepository.save(produto));
    }

    @Override
    public ProdutoModel alterar(ProdutoModel model) {
        var produto = this.buscarProdutoId(model.getId());
        produto.editar(model.getNome(), model.getValor());
        return new ProdutoModel(this.produtoRepository.save(produto));
    }

    @Override
    public ProdutoModel remover(UUID id) {
        Produto produto = this.buscarProdutoId(id);
        produtoRepository.delete(produto);
        return new ProdutoModel(produto);
    }

    private Produto buscarProdutoId(UUID id) {
        return produtoRepository
                .findById(id)
                .orElseThrow(NaoExisteException::new);
    }
}
