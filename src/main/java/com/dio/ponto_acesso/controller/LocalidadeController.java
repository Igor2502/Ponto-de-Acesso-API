package com.dio.ponto_acesso.controller;

import com.dio.ponto_acesso.model.Localidade;
import com.dio.ponto_acesso.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

    LocalidadeService localidadeService;

    @Autowired
    public LocalidadeController(LocalidadeService localidadeService) {
        this.localidadeService = localidadeService;
    }

    @PostMapping
    public Localidade createLocalidade(@RequestBody Localidade localidade) {
        return localidadeService.save(localidade);
    }

    @GetMapping
    public List<Localidade> getLocalidades() {
        return localidadeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Localidade> getLocalidadeById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(localidadeService.findById(id).orElseThrow(() -> new Exception("Localidade não encontrada.")));
    }

    @PutMapping
    public Localidade updateLocalidade(@RequestBody Localidade localidade) {
        return localidadeService.update(localidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Localidade> deleteLocalidadeById(@PathVariable("id") Long id) {
        try {
            localidadeService.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
