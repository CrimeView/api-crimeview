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
 
        Dados dados = repository.findById(id).get();
        dados.setHabilitado(Boolean.FALSE);
        super.preencherCamposAuditoria(dados);
 
        repository.save(dados);
    }

    @Transactional
    public Dados save(Dados dados) {

        super.preencherCamposAuditoria(dados);
        return repository.save(dados);
    }

    public List<Dados> listarTodos() {
  
        return repository.findAll();
    }
 
    public Dados obterPorID(Long id) {
 
        return repository.findById(id).get();
    }

    @Transactional
   public void update(Long id, Dados dadoAlterado) {

      Dados dado = repository.findById(id).get();
      dado.setRegiao(dadoAlterado.getRegiao());
      dado.setData(dadoAlterado.getData());
      dado.setNatureza(dadoAlterado.getNatureza());
      dado.setMunicipio(dadoAlterado.getMunicipio());
      dado.setVitima(dadoAlterado.getVitima());
      dado.setStatus_dado(dadoAlterado.getStatus_dado());
      dado.setId_usuario(dadoAlterado.getId_usuario());
	    
      super.preencherCamposAuditoria(dado);
      repository.save(dado);
  }

 

}
