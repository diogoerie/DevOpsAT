package com.example.pedidos.repository;

import com.example.pedidos.entity.Pedido;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PedidoRepository extends ReactiveCrudRepository<Pedido, Long> {
}
