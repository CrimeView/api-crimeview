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
    public Dados save(Dados dados) {
        return repository.save(dados);
    }

    public List<Dados> listarTodos() {

        return repository.findAllOrderedByDataDesc();
    }

     public Dados obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Dados dadosAlterado) {

        Dados dados = repository.findById(id).get();
        dados.setRegiao(dadosAlterado.getRegiao());
        dados.setData(dadosAlterado.getData());
        dados.setNatureza(dadosAlterado.getNatureza());
        dados.setMunicipio(dadosAlterado.getMunicipio());
        dados.setVitima(dadosAlterado.getVitima());
        dados.setStatusDado(dadosAlterado.getStatusDado());

        repository.save(dados);
    }

    @Transactional
    public void delete(Long id) {

        Dados dados = repository.findById(id).get();
        dados.setStatusDado(Boolean.FALSE);

        repository.save(dados);
    }

}
