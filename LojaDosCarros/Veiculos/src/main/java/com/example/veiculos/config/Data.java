package com.example.veiculos.config;


import com.example.veiculos.entity.Veiculo;
import com.example.veiculos.repository.VeiculoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Data {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @PostConstruct
    public void init() {
        Veiculo veiculo1 = new Veiculo("Ford Mustang", "Esportivo", 2022);
        Veiculo veiculo2 = new Veiculo("Chevrolet Camaro", "Esportivo", 2021);
        Veiculo veiculo3 = new Veiculo("Toyota Corolla", "Sedan", 2020);
        Veiculo veiculo4 = new Veiculo("Honda Civic", "Sedan", 2019);

        veiculoRepository.save(veiculo1);
        veiculoRepository.save(veiculo2);
        veiculoRepository.save(veiculo3);
        veiculoRepository.save(veiculo4);
    }
}
