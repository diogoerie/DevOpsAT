package com.example.pedidos.controller;

import com.example.pedidos.entity.Pedido;
import com.example.pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/pedidos")
public class PedidosController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Pedido> getAllPedidos() {
        return pedidoService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Pedido> getPedidoById(@PathVariable Long id) {
        return pedidoService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Pedido> createPedido(@RequestBody Pedido pedido) {
        return pedidoService.save(pedido);
    }
}
