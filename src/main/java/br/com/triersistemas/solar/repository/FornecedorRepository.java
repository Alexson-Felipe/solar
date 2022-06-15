package br.com.triersistemas.solar.repository;

import br.com.triersistemas.solar.domain.Fornecedor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FornecedorRepository {

    List<Fornecedor> consultar();
    Optional<Fornecedor> consultar(UUID id);
    void cadastrar(Fornecedor fornecedor);
    void remover(Fornecedor fornecedor);

}
