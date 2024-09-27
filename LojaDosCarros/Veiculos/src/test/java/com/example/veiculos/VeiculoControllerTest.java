package com.example.veiculos;

import com.example.veiculos.entity.Veiculo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class VeiculoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testListarVeiculos() throws Exception {
        mockMvc.perform(get("/veiculos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(greaterThan(0))));
    }

    @Test
    public void testAdicionarVeiculo() throws Exception {
        Veiculo novoVeiculo = new Veiculo("Fiat Uno", "Hatchback", 2018);

        mockMvc.perform(post("/veiculos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(novoVeiculo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.modelo", is("Fiat Uno")))
                .andExpect(jsonPath("$.tipo", is("Hatchback")))
                .andExpect(jsonPath("$.ano", is(2018)));
    }

    @Test
    public void testBuscarVeiculoPorId() throws Exception {
        mockMvc.perform(get("/veiculos/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)));
    }

    @Test
    public void testRemoverVeiculo() throws Exception {
        mockMvc.perform(delete("/veiculos/1"))
                .andExpect(status().isNoContent());
    }
}
