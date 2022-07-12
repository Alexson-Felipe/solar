package br.com.triersistemas.solar.controller;

import br.com.triersistemas.solar.domain.Fornecedor;
import br.com.triersistemas.solar.model.FornecedorModel;
import br.com.triersistemas.solar.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/consultar")
    public List<FornecedorModel> consultar() {
        return fornecedorService.consultar();
    }

    @PostMapping("/cadastrar-randon")
    public FornecedorModel cadastrarRandon() {
        return fornecedorService.cadastrarRandon();
    }

    @PostMapping("/cadastrar")
    public FornecedorModel cadastrar(@RequestBody FornecedorModel model) {
        return fornecedorService.cadastrar(model);
    }

    @PutMapping("/alterar")
    public FornecedorModel alterar(@RequestBody FornecedorModel model) {
        return fornecedorService.alterar(model);
    }

    @DeleteMapping("/remover/{id}")
    public FornecedorModel remover(@PathVariable UUID id) {
        return fornecedorService.remover(id);
    }
}