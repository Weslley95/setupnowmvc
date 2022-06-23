package br.com.wpb.mvc.setupnow.controller;

import br.com.wpb.mvc.setupnow.model.StatusPedido;
import br.com.wpb.mvc.setupnow.repository.PedidoRepository;
import br.com.wpb.mvc.setupnow.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping
    public String home(Model model) {
        List<Pedido> pedidoList = pedidoRepository.findAll();

        model.addAttribute("pedidoList", pedidoList);
        return "home";
    }

    @GetMapping("/{statusPedido}")
    public String statusPedido(@PathVariable("statusPedido") String statusPedido, Model model) {
        List<Pedido> pedidoList = pedidoRepository.findByStatusPedido(StatusPedido.valueOf(statusPedido.toUpperCase()));

        model.addAttribute("pedidoList", pedidoList);
        model.addAttribute("statusPedido", statusPedido);
        return "home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/home";
    }
}
