package br.com.triersistemas.solar.service;

import br.com.triersistemas.solar.model.ProdutoModel;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {

    List<ProdutoModel> consultar();
    ProdutoModel consultar(UUID id);
    List<ProdutoModel> consultar(List<UUID> idProdutos);
    ProdutoModel cadastrar(ProdutoModel model);
    ProdutoModel alterar(ProdutoModel model);

    ProdutoModel remover(UUID id);
}
