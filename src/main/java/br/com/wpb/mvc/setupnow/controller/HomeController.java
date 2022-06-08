package br.com.wpb.mvc.setupnow.controller;

import br.com.wpb.mvc.setupnow.model.Pedido;
import lombok.var;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    private EntityManager entityManager;

    @GetMapping("/home")
    public String home(Model model) {
        //var pedido = new Pedido();
        //pedido.setNomeProduto("Smart Watch Relógio Inteligente Mi Watch S1 - Xiaomi");
        //pedido.setUrlImagem("https://cdn.shopify.com/s/files/1/0543/3507/8599/products/S8ad16487b4144a268c1153edb239cd61W.png?v=1649735560");
        //pedido.setUrlProduto("https://www.midobr.com/collections/smartwatch/products/lancamento-smart-watch-relogio-inteligente-mi-watch-s1-xiaomi");
        //pedido.setDescricao("Lançamento");

        Query query = entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class);
        List<Pedido> pedidoList = query.getResultList();

        model.addAttribute("pedidoList", pedidoList);
        return "home";
    }
}
