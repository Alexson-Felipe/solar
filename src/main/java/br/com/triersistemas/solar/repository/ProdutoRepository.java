package br.com.triersistemas.solar.repository;

import br.com.triersistemas.solar.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

    /*
    List<Produto> consultar();
    Optional<Produto> consultar(UUID id);
    void cadastrar(Produto produto);
    void remover(Produto produto);

     */
}
