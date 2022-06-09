package br.com.triersistemas.solar.controller;

import br.com.triersistemas.solar.domain.Farmaceutico;
import br.com.triersistemas.solar.exceptions.NaoExisteException;
import br.com.triersistemas.solar.model.FarmaceuticoModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/farmaceutico")
public class FarmaceuticoController {

    public static final List<Farmaceutico> LIST = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Farmaceutico> consultar() {
        return LIST;
    }

    @PostMapping("/cadastrar-randon")
    public Farmaceutico cadastrarRandon() {
        final var f = new Farmaceutico();
        LIST.add(f);
        return f;
    }

    @PostMapping("/cadastrar")
    public Farmaceutico cadastrar(@RequestBody FarmaceuticoModel model) {
        var f = new Farmaceutico(model.getNome(), model.getAniver(), model.getCpf());
        LIST.add(f);
        return f;
    }

    @PutMapping("/alterar/{id}")
    public Farmaceutico remover(@PathVariable UUID id, @RequestBody FarmaceuticoModel model) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        domain.editar(model.getNome(), model.getAniver(), model.getCpf());
        return domain;
    }

    @DeleteMapping("/remover/{id}")
    public Farmaceutico remover(@PathVariable UUID id) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        LIST.remove(domain);
        return domain;
    }
}