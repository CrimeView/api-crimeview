package com.crimeview.api.api.dados;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


import com.crimeview.api.modelo.dados.Dados;
import com.crimeview.api.modelo.dados.DadosService;
import com.crimeview.api.util.entity.GenericController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/dados")
public class DadosController extends GenericController {

    @Autowired
    private DadosService dadosService;

    @ApiOperation(value = "Serviço responsável por salvar um dado.")
    @PostMapping
    public ResponseEntity<Dados> save(@RequestBody @Valid DadosRequest request) {
        Dados dados = dadosService.save(request.build());
        return new ResponseEntity<Dados>(dados, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        dadosService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Serviço responsável por listar todos os dados.")
    @GetMapping
    public List<Dados> listarTodos() {
        return dadosService.listarTodos();
    }

    @ApiOperation(value = "Serviço responsável por obter um dado referente ao Id passado na URL.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna  o cliente."),
            @ApiResponse(code = 401, message = "Acesso não autorizado."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
            @ApiResponse(code = 404, message = "Não foi encontrado um registro para o Id informado."),
            @ApiResponse(code = 500, message = "Foi gerado um erro no servidor."),
    })

    @GetMapping("/{id}")
    public Dados obterPorID(@PathVariable Long id) {
        return dadosService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dados> update(@PathVariable("id") Long id, @RequestBody DadosRequest request) {
        dadosService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

}
