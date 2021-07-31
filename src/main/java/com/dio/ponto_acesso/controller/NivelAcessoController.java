package com.dio.ponto_acesso.controller;

import com.dio.ponto_acesso.model.NivelAcesso;
import com.dio.ponto_acesso.service.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nivel")
public class NivelAcessoController {

    NivelAcessoService nivelAcessoService;

    @Autowired
    public NivelAcessoController(NivelAcessoService nivelAcessoService) {
        this.nivelAcessoService = nivelAcessoService;
    }

    @PostMapping
    public NivelAcesso createNivelAcesso(@RequestBody NivelAcesso nivelAcesso) {
        return nivelAcessoService.save(nivelAcesso);
    }

    @GetMapping
    public List<NivelAcesso> getNiveisAcesso() {
        return nivelAcessoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NivelAcesso> getNivelAcessoById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(nivelAcessoService.findById(id).orElseThrow(() -> new Exception("Nivel de acesso não encontrado.")));
    }

    @PutMapping
    public NivelAcesso updateNivelAcesso(@RequestBody NivelAcesso nivelAcesso) {
        return nivelAcessoService.update(nivelAcesso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<NivelAcesso> deleteNivelAcesso(@PathVariable("id") Long id) {
        try {
            nivelAcessoService.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
