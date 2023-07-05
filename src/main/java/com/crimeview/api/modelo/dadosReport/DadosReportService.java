package com.crimeview.api.modelo.dadosReport;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crimeview.api.util.entity.GenericService;

@Service
public class DadosReportService extends GenericService {

    @Autowired
    private DadosReportRepository repository;

    @Transactional
    public DadosReport save(DadosReport dados) {
        return repository.save(dados);
    }

    public List<DadosReport> listarTodos() {

        return repository.findAllOrderedByDataDesc();
    }

     public DadosReport obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, DadosReport dadosAlterado) {

        DadosReport dados = repository.findById(id).get();
        dados.setRegiao(dadosAlterado.getRegiao());
        dados.setData(dadosAlterado.getData());
        dados.setNatureza(dadosAlterado.getNatureza());
        dados.setMunicipio(dadosAlterado.getMunicipio());
        dados.setVitima(dadosAlterado.getVitima());
        dados.setStatusDado(dadosAlterado.getStatusDado());
        dados.setId_usuario(dadosAlterado.getId_usuario());

        repository.save(dados);
    }

    @Transactional
    public void delete(Long id) {

        DadosReport dados = repository.findById(id).get();
        dados.setStatusDado(Boolean.FALSE);

        repository.save(dados);
    }

}
