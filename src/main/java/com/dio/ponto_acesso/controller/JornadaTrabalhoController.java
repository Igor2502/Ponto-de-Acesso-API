package com.dio.ponto_acesso.controller;

import com.dio.ponto_acesso.model.JornadaTrabalho;
import com.dio.ponto_acesso.service.JornadaTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaTrabalhoService jornadaTrabalhoService;

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaTrabalhoService.save(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> getJornadasTrabalho() {
        return jornadaTrabalhoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JornadaTrabalho> getJornadaTrabalhoById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(jornadaTrabalhoService.findById(id).orElseThrow(() -> new Exception("Jornada de Trabalho não encontrada.")));
    }

    @PutMapping
    public JornadaTrabalho updateJornadaTrabalho(JornadaTrabalho jornadaTrabalho) {
        return jornadaTrabalhoService.update(jornadaTrabalho);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteJornadaTrabalhoById(@PathVariable("id") long id) throws Exception {
        try {
            jornadaTrabalhoService.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity) ResponseEntity.ok();
    }
}
