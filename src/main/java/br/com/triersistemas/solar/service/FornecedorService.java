package br.com.triersistemas.solar.service;

import br.com.triersistemas.solar.domain.Fornecedor;
import br.com.triersistemas.solar.model.FornecedorModel;

import java.util.List;
import java.util.UUID;

public interface FornecedorService {

    List<FornecedorModel> consultar();

    FornecedorModel consultar(UUID id);

    FornecedorModel cadastrar(FornecedorModel model);
    FornecedorModel cadastrarRandon();

    FornecedorModel alterar(FornecedorModel model);

    FornecedorModel remover(UUID id);

}
