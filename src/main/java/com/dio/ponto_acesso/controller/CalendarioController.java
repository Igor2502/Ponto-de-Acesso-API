package com.dio.ponto_acesso.controller;

import com.dio.ponto_acesso.model.Calendario;
import com.dio.ponto_acesso.service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {

    CalendarioService calendarioService;

    @Autowired
    public CalendarioController(CalendarioService calendarioService) {
        this.calendarioService = calendarioService;
    }

    @PostMapping
    public Calendario createCalendario(@RequestBody Calendario calendario) {
        return calendarioService.save(calendario);
    }

    @GetMapping
    public List<Calendario> getCalendarios() {
        return calendarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calendario> getCalendarioById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(calendarioService.findById(id).orElseThrow(() -> new Exception("Calendario não encontrado.")));
    }

    @PutMapping
    public Calendario updateCalendario(@RequestBody Calendario calendario) {
        return calendarioService.update(calendario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Calendario> deleteCalendarioById(@PathVariable("id") Long id) {
        try {
            calendarioService.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
