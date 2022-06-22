package br.com.wpb.mvc.setupnow.controller;

import br.com.wpb.mvc.setupnow.dto.RequisicaoNovoPedido;
import br.com.wpb.mvc.setupnow.model.Pedido;
import br.com.wpb.mvc.setupnow.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/pedido")
public class PedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping("/formulario")
    public String formulario() {
        return "pedido/formulario";
    }

    @PostMapping("/novo")
    public String novo(RequisicaoNovoPedido requisicao) {

        Pedido pedido = requisicao.toPedido();
        pedidoRepository.save(pedido);

        return "pedido/formulario";
    }
}
