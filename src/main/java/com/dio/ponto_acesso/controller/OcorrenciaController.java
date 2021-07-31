package com.dio.ponto_acesso.controller;

import com.dio.ponto_acesso.model.Ocorrencia;
import com.dio.ponto_acesso.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

    OcorrenciaService ocorrenciaService;

    @Autowired
    public OcorrenciaController(OcorrenciaService ocorrenciaService) {
        this.ocorrenciaService = ocorrenciaService;
    }

    @PostMapping
    public Ocorrencia createOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaService.save(ocorrencia);
    }

    @GetMapping
    public List<Ocorrencia> getOcorrencias() {
        return ocorrenciaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ocorrencia> getOcorrenciaById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(ocorrenciaService.findById(id).orElseThrow(() -> new Exception("Ocorrencia não encontrada.")));
    }

    @PutMapping
    public Ocorrencia updateOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaService.update(ocorrencia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ocorrencia> deleteOcorrenciaById(@PathVariable("id") Long id) {
        try {
            ocorrenciaService.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
