package com.example.cliente.config;

import com.example.cliente.entity.Cliente;
import com.example.cliente.repository.ClienteRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Data {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostConstruct
    public void init() {
        Cliente cliente1 = new Cliente("João da Silva Sauro", "202251212");
        Cliente cliente2 = new Cliente("Maria da Costa Oliveira", "75757575");
        Cliente cliente3 = new Cliente("Consuelo Martines", "454575545");
        Cliente cliente4 = new Cliente("Victor Hugo da Silveira", "544557545");

        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);
        clienteRepository.save(cliente3);
        clienteRepository.save(cliente4);
    }
}