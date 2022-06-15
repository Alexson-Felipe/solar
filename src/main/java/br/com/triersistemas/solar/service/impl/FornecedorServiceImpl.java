package br.com.triersistemas.solar.service.impl;

import br.com.triersistemas.solar.domain.Fornecedor;
import br.com.triersistemas.solar.exceptions.NaoExisteException;
import br.com.triersistemas.solar.model.FornecedorModel;
import br.com.triersistemas.solar.repository.FornecedorRepository;
import br.com.triersistemas.solar.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;


    @Override
    public List<Fornecedor> consultar() {
        return fornecedorRepository.consultar();
    }

    @Override
    public Fornecedor consultar(UUID id) {
        return fornecedorRepository.consultar(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Fornecedor cadastrar(FornecedorModel model) {
        Fornecedor fornecedor = new Fornecedor(model.getNome(), model.getAniver(), model.getCnpj());
        fornecedorRepository.cadastrar(fornecedor);
        return fornecedor;
    }

    @Override
    public Fornecedor cadastrarRandon() {
        Fornecedor fornecedor = new Fornecedor();
        fornecedorRepository.cadastrar(fornecedor);
        return fornecedor;
    }

    @Override
    public Fornecedor alterar(UUID id, FornecedorModel model) {
        Fornecedor fornecedor = this.consultar(id);
        fornecedor.editar(model.getNome(), model.getAniver(), model.getCnpj());
        return fornecedor;
    }

    @Override
    public Fornecedor remover(UUID id) {
        Fornecedor fornecedor = this.consultar(id);
        fornecedorRepository.remover(fornecedor);
        return fornecedor;
    }
}
