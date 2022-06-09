package br.com.wpb.mvc.setupnow.controller;

import br.com.wpb.mvc.setupnow.repository.PedidoRepository;
import br.com.wpb.mvc.setupnow.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping("/home")
    public String home(Model model) {
        List<Pedido> pedidoList = pedidoRepository.findAll();

        model.addAttribute("pedidoList", pedidoList);
        return "home";
    }
}
