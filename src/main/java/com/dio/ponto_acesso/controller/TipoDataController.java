package com.dio.ponto_acesso.controller;

import com.dio.ponto_acesso.model.TipoData;
import com.dio.ponto_acesso.service.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo")
public class TipoDataController {

    TipoDataService tipoDataService;

    @Autowired
    public TipoDataController(TipoDataService tipoDataService) {
        this.tipoDataService = tipoDataService;
    }

    @PostMapping
    public TipoData createTipoData(@RequestBody TipoData tipoData) {
        return tipoDataService.save(tipoData);
    }

    @GetMapping
    public List<TipoData> getTiposDatas() {
        return tipoDataService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoData> getTipoDataById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(tipoDataService.findById(id).orElseThrow(() -> new Exception("Tipo data não encontrada.")));
    }

    @PutMapping
    public TipoData updateTipoData(@RequestBody TipoData tipoData) {
        return tipoDataService.update(tipoData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoData> deleteById(@PathVariable("id") Long id) {
        try {
            tipoDataService.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
