package com.dio.ponto_acesso.controller;

import com.dio.ponto_acesso.model.Empresa;
import com.dio.ponto_acesso.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    EmpresaService empresaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public Empresa createEmpresa(@RequestBody Empresa empresa) {
        return empresaService.save(empresa);
    }

    @GetMapping
    public List<Empresa> getEmpresas() {
        return empresaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(empresaService.findById(id).orElseThrow(() -> new Exception("Empresa não encontrada.")));
    }

    @PutMapping
    public Empresa updateEmpresa(@RequestBody Empresa empresa) {
        return empresaService.update(empresa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Empresa> deleteEmpresaById(@PathVariable("id") Long id) {
        try {
            empresaService.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
