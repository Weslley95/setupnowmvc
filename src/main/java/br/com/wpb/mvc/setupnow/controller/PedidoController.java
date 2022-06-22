package br.com.wpb.mvc.setupnow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/pedido")
public class PedidoController {

    @GetMapping("/formulario")
    public String formulario() {
        return "pedido/formulario";
    }
}
