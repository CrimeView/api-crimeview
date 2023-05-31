package com.crimeview.api.api.adimin;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crimeview.api.modelo.adimin.Adimin;
import com.crimeview.api.modelo.adimin.AdiminService;
import com.crimeview.api.util.entity.GenericController;

@RestController
@RequestMapping("/api/admin")
public class AdiminController extends GenericController {

   @Autowired
   private AdiminService adiminService;

   @PostMapping
   public ResponseEntity<Adimin> save(@RequestBody @Valid AdiminRequest request) {

      
       Adimin adimin = adiminService.save(request.build());
       return new ResponseEntity<Adimin>(adimin, HttpStatus.CREATED);
   }

}