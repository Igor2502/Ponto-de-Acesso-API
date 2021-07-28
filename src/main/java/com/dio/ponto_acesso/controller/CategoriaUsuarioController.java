package com.dio.ponto_acesso.controller;

import com.dio.ponto_acesso.model.CategoriaUsuario;
import com.dio.ponto_acesso.service.CategoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaUsuarioController {

    CategoriaUsuarioService categoriaUsuarioService;

    @Autowired
    public CategoriaUsuarioController(CategoriaUsuarioService categoriaUsuarioService) {
        this.categoriaUsuarioService = categoriaUsuarioService;
    }

    @PostMapping
    public CategoriaUsuario createCategoriaUsuario(CategoriaUsuario categoriaUsuario) {
        return categoriaUsuarioService.save(categoriaUsuario);
    }

    @GetMapping
    public List<CategoriaUsuario> getCategoriasUsuarios() {
        return categoriaUsuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaUsuario> getCategoriaUsuarioById(@PathVariable("id") Long id) throws Exception{
        return ResponseEntity.ok(categoriaUsuarioService.findById(id).orElseThrow(() -> new Exception("Categoria usuario não encontrada.")));
    }

    @PutMapping
    public CategoriaUsuario updateCategoriaUsuario(CategoriaUsuario categoriaUsuario) {
        return categoriaUsuarioService.update(categoriaUsuario);
    }

    public ResponseEntity<CategoriaUsuario> deleteCategoriaUsuarioById(@PathVariable("id") Long id) {
        try {
            categoriaUsuarioService.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return (ResponseEntity<CategoriaUsuario>) ResponseEntity.status(500);
        }
        return (ResponseEntity<CategoriaUsuario>) ResponseEntity.ok();
    }
}
