package com.quarto.autores.services;

import com.quarto.autores.models.AutorModel;
import com.quarto.autores.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public AutorModel criarAutor(AutorModel autorModel) {
        return autorRepository.save(autorModel);
    }

    public List<AutorModel> findAll() {
        return autorRepository.findAll();
    }

    public AutorModel findById(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    public void deletarAutor(AutorModel autorModel) {
        autorRepository.delete(autorModel);
    }
}
