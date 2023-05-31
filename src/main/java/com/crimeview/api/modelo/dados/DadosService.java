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

       super.preencherCamposAuditoria(dados);
       return repository.save(dados);
   }

   public List<Dados> listarTodos() {
  
    return repository.findAll();
}

public Dados obterPorID(Long id) {

    return repository.findById(id).get();
}

}
