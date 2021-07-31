package com.dio.ponto_acesso.service;

import com.dio.ponto_acesso.model.NivelAcesso;
import com.dio.ponto_acesso.repository.NivelAcessoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NivelAcessoService {

    NivelAcessoInterface nivelAcessoInterface;

    @Autowired
    public NivelAcessoService(NivelAcessoInterface nivelAcessoInterface) {
        this.nivelAcessoInterface = nivelAcessoInterface;
    }

    public NivelAcesso save(NivelAcesso nivelAcesso) {
        return nivelAcessoInterface.save(nivelAcesso);
    }

    public List<NivelAcesso> findAll() {
        return nivelAcessoInterface.findAll();
    }

    public Optional<NivelAcesso> findById(Long id) {
        return nivelAcessoInterface.findById(id);
    }

    public NivelAcesso update(NivelAcesso nivelAcesso) {
        return nivelAcessoInterface.save(nivelAcesso);
    }

    public void delete(Long id) {
        nivelAcessoInterface.deleteById(id);
    }
}
