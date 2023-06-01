package com.crimeview.api.modelo.admin;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crimeview.api.util.entity.GenericService;

@Service
public class AdminService extends GenericService {

   @Autowired
   private AdminRepository repository;

   @Transactional
   public Admin save(Admin admin) {

       super.preencherCamposAuditoria(admin);
       return repository.save(admin);
   }

   public List<Admin> listarTodos() {
  
    return repository.findAll();
}

public Admin obterPorID(Long id) {

    return repository.findById(id).get();
}


}
