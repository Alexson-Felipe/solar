package br.com.triersistemas.solar.controller;

import br.com.triersistemas.solar.domain.ItemPedido;
import br.com.triersistemas.solar.model.ItemPedidoModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/itempedido")
public class ItemPedidoController {

    public static final List<ItemPedido> LIST = new ArrayList<>();

    @PostMapping("/cadastrar")
    public List<ItemPedido> Cadastrar(@RequestBody ItemPedidoModel model){
        var itemPedido = ProdutoController.LIST.stream().count();

        return LIST;
    }

}
