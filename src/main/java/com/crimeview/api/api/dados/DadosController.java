package com.crimeview.api.api.dados;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
=======
>>>>>>> dc956d05a7acc83faa5a6f05a7b8986209369647
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crimeview.api.modelo.dados.Dados;
import com.crimeview.api.modelo.dados.DadosService;
import com.crimeview.api.util.entity.GenericController;

@RestController
@RequestMapping("/api/dados")
public class DadosController extends GenericController {

   @Autowired
   private DadosService dadosService;

   @PostMapping
   public ResponseEntity<Dados> save(@RequestBody @Valid DadosRequest request) {

       Dados dados = dadosService.save(request.build());
       return new ResponseEntity<Dados>(dados, HttpStatus.CREATED);
   }

   @GetMapping
<<<<<<< HEAD
   public List<Dados> listarTodos() {
  
       return dadosService.listarTodos();
   }

   @GetMapping("/{id}")
   public Dados obterPorID(@PathVariable Long id) {

       return dadosService.obterPorID(id);
   }


=======
   public List<Dados> listAll() {
       return dadosService.listAll();
   }
>>>>>>> dc956d05a7acc83faa5a6f05a7b8986209369647
}
