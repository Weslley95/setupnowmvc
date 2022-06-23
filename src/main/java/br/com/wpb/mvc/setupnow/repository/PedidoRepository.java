package br.com.wpb.mvc.setupnow.repository;

import br.com.wpb.mvc.setupnow.model.Pedido;
import br.com.wpb.mvc.setupnow.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByStatusPedido(StatusPedido statusPedido);
}
