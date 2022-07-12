package br.com.triersistemas.solar.repository;

import br.com.triersistemas.solar.domain.Farmaceutico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface FarmaceuticoRepository extends JpaRepository<Farmaceutico, UUID> {

    /*
    List<Farmaceutico> consultar();
    Optional<Farmaceutico> consultar(UUID id);
    void cadastrar(Farmaceutico farmaceutico);
    void remover(Farmaceutico farmaceutico);


     */
}
