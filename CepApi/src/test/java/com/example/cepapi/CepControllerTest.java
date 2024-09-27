package com.example.cepapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
public class CepControllerTest {

    @Test
    public void testGetCepInfo() {
        WebClient webClient = WebClient.create("https://viacep.com.br/ws");
    }
}
