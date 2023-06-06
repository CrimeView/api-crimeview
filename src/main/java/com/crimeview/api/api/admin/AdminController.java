package com.crimeview.api.api.admin;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crimeview.api.modelo.admin.Admin;
import com.crimeview.api.modelo.admin.AdminService;
import com.crimeview.api.util.entity.GenericController;

@RestController
@RequestMapping("/api/admin")
public class AdminController extends GenericController {

   @Autowired
   private AdminService adminService;

   @PostMapping
   public ResponseEntity<Admin> save(@RequestBody @Valid AdminRequest request) {

      
       Admin admin = adminService.save(request.build());
       return new ResponseEntity<Admin>(admin, HttpStatus.CREATED);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       adminService.delete(id);
       return ResponseEntity.ok().build();
   }

   @PutMapping("/{id}")
   public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody ClienteRequest request) {

       clienteService.update(id, request.build());
       return ResponseEntity.ok().build();
   }



   @GetMapping
   public List<Admin> listarTodos() {
  
       return adminService.listarTodos();
   }

   @GetMapping("/{id}")
   public Admin obterPorID(@PathVariable Long id) {

       return adminService.obterPorID(id);
   }


}