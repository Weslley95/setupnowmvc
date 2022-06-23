package br.com.wpb.mvc.setupnow.dto;

import br.com.wpb.mvc.setupnow.model.Pedido;
import lombok.Getter;
import lombok.Setter;
import lombok.var;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RequisicaoNovoPedido {

    @NotBlank
    private String nomeProduto;
    @NotBlank
    private String urlProduto;
    @NotBlank
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
