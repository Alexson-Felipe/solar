package br.com.triersistemas.solar.repository;

import br.com.triersistemas.solar.domain.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, UUID> {
/*
    List<Fornecedor> consultar();
    Optional<Fornecedor> consultar(UUID id);
    void cadastrar(Fornecedor fornecedor);
    void remover(Fornecedor fornecedor);

 */

}
