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
    public List<FornecedorModel> consultar() {
        return fornecedorRepository.findAll().stream().map(FornecedorModel::new).toList();
    }

    @Override
    public FornecedorModel consultar(UUID id) {
        return new FornecedorModel(this.buscarFornecedorId(id));
    }

    @Override
    public FornecedorModel cadastrar(FornecedorModel model) {
        var fornecedor = new Fornecedor(model);
        return new FornecedorModel(fornecedorRepository.save(fornecedor));
    }

    @Override
    public FornecedorModel cadastrarRandon() {
        var fornecedor = new Fornecedor();
        return new FornecedorModel(fornecedorRepository.save(fornecedor));
    }

    @Override
    public FornecedorModel alterar(FornecedorModel model) {
        var fornecedor = this.buscarFornecedorId(model.getId());
        fornecedor.editar(model.getNome(), model.getAniver(), model.getCnpj());
        return new FornecedorModel(this.fornecedorRepository.save(fornecedor));
    }

    @Override
    public FornecedorModel remover(UUID id) {
        Fornecedor fornecedor = this.buscarFornecedorId(id);
        fornecedorRepository.delete(fornecedor);
        return new FornecedorModel(fornecedor);
    }

    private Fornecedor buscarFornecedorId(UUID id){
        return fornecedorRepository.findById(id).orElseThrow(NaoExisteException::new);
    }
}
