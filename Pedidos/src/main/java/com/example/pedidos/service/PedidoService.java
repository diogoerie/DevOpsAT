package com.example.pedidos.service;

import com.example.pedidos.entity.Pedido;
import com.example.pedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public Flux<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Mono<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    public Mono<Pedido> save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}
