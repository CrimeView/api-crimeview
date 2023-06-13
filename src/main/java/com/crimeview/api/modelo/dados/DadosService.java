package com.crimeview.api.modelo.dados;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crimeview.api.util.entity.GenericService;

@Service
public class DadosService extends GenericService {

    @Autowired
    private DadosRepository repository;

    @Transactional
    public void delete(Long id) {
        Dados dados = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Dados não encontrados para o ID: " + id));
        if (!dados.getStatusDado()) {
            throw new IllegalArgumentException(
                    "Os dados com o ID: " + id + " já estão marcados como excluídos logicamente.");
        }
        dados.setStatusDado(false);
        repository.save(dados);
    }

    @Transactional
    public Dados save(Dados dados) {
        return repository.save(dados);
    }

    public List<Dados> listarTodos() {
        return repository.findAllByStatusDadoTrue();
    }

    public Dados obterPorID(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dados não encontrados para o ID: " + id));
    }

    @Transactional
public void update(Long id, Dados dadoAlterado) {
    Dados dado = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Dados não encontrados para o ID: " + id));
    
    if (!dado.getStatusDado()) {
        throw new IllegalArgumentException("Os dados com o ID: " + id + " já estão marcados como excluídos logicamente.");
    }
    
    dado.setRegiao(dadoAlterado.getRegiao());
    dado.setData(dadoAlterado.getData());
    dado.setNatureza(dadoAlterado.getNatureza());
    dado.setMunicipio(dadoAlterado.getMunicipio());
    dado.setVitima(dadoAlterado.getVitima());
    dado.setStatusDado(dadoAlterado.getStatusDado());
    dado.setId_usuario(dadoAlterado.getId_usuario());
	
    
    repository.save(dado);
}

}
