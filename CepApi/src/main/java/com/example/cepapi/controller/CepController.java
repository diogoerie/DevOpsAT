package com.example.cepapi.controller;

import com.example.cepapi.entity.CepResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cep")
public class CepController {

    private final WebClient webClient;

    public CepController(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://viacep.com.br/ws").build();
    }

    @GetMapping("/{cep}")
    public Mono<CepResponse> getCepInfo(@PathVariable String cep) {
        return webClient.get()
                .uri("/{cep}/json/", cep)
                .retrieve()
                .bodyToMono(CepResponse.class);
    }
}
