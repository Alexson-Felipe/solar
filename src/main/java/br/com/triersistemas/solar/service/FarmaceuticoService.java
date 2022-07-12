package br.com.triersistemas.solar.service;

import br.com.triersistemas.solar.model.FarmaceuticoModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public interface FarmaceuticoService {

    List<FarmaceuticoModel> consultar();
    FarmaceuticoModel consultar(UUID id);
    FarmaceuticoModel cadastrar(FarmaceuticoModel model);
    FarmaceuticoModel cadastrarRandon();
    FarmaceuticoModel alterar(FarmaceuticoModel model);
    FarmaceuticoModel remover(UUID id);

}
