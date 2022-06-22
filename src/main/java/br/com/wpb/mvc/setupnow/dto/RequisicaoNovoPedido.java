package br.com.wpb.mvc.setupnow.dto;

import br.com.wpb.mvc.setupnow.model.Pedido;
import lombok.Getter;
import lombok.Setter;
import lombok.var;

@Getter
@Setter
public class RequisicaoNovoPedido {

    private String nomeProduto;
    private String urlProduto;
    private String urlImagem;
    private String descricao;

    public Pedido toPedido() {
        var pedido = new Pedido();
        pedido.setNomeProduto(nomeProduto);
        pedido.setUrlProduto(urlProduto);
        pedido.setUrlImagem(urlImagem);
        pedido.setDescricao(descricao);

        return pedido;
    }
}
