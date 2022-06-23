package br.com.wpb.mvc.setupnow.controller;

import br.com.wpb.mvc.setupnow.dto.RequisicaoNovoPedido;
import br.com.wpb.mvc.setupnow.model.Pedido;
import br.com.wpb.mvc.setupnow.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/pedido")
public class PedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping("/formulario")
    public String formulario(RequisicaoNovoPedido requisicao) {
        return "pedido/formulario";
    }

    @PostMapping("/novo")
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {

        if(result.hasErrors()) {
            return "pedido/formulario";
        }

        Pedido pedido = requisicao.toPedido();
        pedidoRepository.save(pedido);

        return "pedido/formulario";
    }
}
