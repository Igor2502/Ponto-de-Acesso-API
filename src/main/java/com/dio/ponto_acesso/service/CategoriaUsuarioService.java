package com.dio.ponto_acesso.service;

import com.dio.ponto_acesso.model.CategoriaUsuario;
import com.dio.ponto_acesso.repository.CategoriaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaUsuarioService {

    CategoriaUsuarioRepository categoriaUsuarioRepository;

    @Autowired
    public CategoriaUsuarioService(CategoriaUsuarioRepository categoriaUsuarioRepository) {
        this.categoriaUsuarioRepository = categoriaUsuarioRepository;
    }

    public CategoriaUsuario save(CategoriaUsuario categoriaUsuario) {
        return categoriaUsuarioRepository.save(categoriaUsuario);
    }

    public List<CategoriaUsuario> findAll() {
        return categoriaUsuarioRepository.findAll();
    }

    public Optional<CategoriaUsuario> findById(Long id) {
        return categoriaUsuarioRepository.findById(id);
    }

    public CategoriaUsuario update(CategoriaUsuario categoriaUsuario) {
        return categoriaUsuarioRepository.save(categoriaUsuario);
    }

    public void delete(Long id) {
        categoriaUsuarioRepository.deleteById(id);
    }
}
