package com.dio.ponto_acesso.service;

import com.dio.ponto_acesso.model.TipoData;
import com.dio.ponto_acesso.repository.TipoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDataService {

    TipoDataRepository tipoDataRepository;

    @Autowired
    public TipoDataService(TipoDataRepository tipoDataRepository) {
        this.tipoDataRepository = tipoDataRepository;
    }

    public TipoData save(TipoData tipoData) {
        return tipoDataRepository.save(tipoData);
    }

    public List<TipoData> findAll() {
        return tipoDataRepository.findAll();
    }

    public Optional<TipoData> findById(Long id) {
        return tipoDataRepository.findById(id);
    }

    public TipoData update(TipoData tipoData) {
        return tipoDataRepository.save(tipoData);
    }

    public void delete(Long id) {
        tipoDataRepository.deleteById(id);
    }
}
