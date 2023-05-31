package com.crimeview.api.modelo.adimin;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crimeview.api.util.entity.GenericService;

@Service
public class AdiminService extends GenericService {

   @Autowired
   private AdiminRepository repository;

   @Transactional
   public Adimin save(Adimin adimin) {

       super.preencherCamposAuditoria(adimin);
       return repository.save(adimin);
   }

   public List<Adimin> listarTodos() {
  
    return repository.findAll();
}

public Adimin obterPorID(Long id) {

    return repository.findById(id).get();
}


}
