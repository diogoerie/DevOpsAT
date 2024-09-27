package com.example.veiculos.service;


import com.example.veiculos.entity.Veiculo;
import com.example.veiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> buscarPorId(Long id) {
        return veiculoRepository.findById(id);
    }

    public Veiculo adicionarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Veiculo atualizarVeiculo(Long id, Veiculo veiculoAtualizado) {
        Optional<Veiculo> veiculoExistente = veiculoRepository.findById(id);
        if (veiculoExistente.isPresent()) {
            Veiculo veiculo = veiculoExistente.get();
            veiculo.setModelo(veiculoAtualizado.getModelo());
            veiculo.setTipo(veiculoAtualizado.getTipo());
            veiculo.setAno(veiculoAtualizado.getAno());
            return veiculoRepository.save(veiculo);
        } else {
            throw new RuntimeException("Veículo não encontrado");
        }
    }

    public void removerVeiculo(Long id) {
        veiculoRepository.deleteById(id);
    }
}
