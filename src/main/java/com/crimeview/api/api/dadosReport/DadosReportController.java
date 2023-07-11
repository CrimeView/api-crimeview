package com.crimeview.api.api.dadosReport;

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

import com.crimeview.api.modelo.dadosReport.DadosReportService;
import com.crimeview.api.modelo.dadosReport.DadosReport;
import com.crimeview.api.util.entity.GenericController;

@RestController
@RequestMapping("/api/dadosReport")
public class DadosReportController extends GenericController {

    @Autowired
    private DadosReportService dadosReportService;

    @ApiOperation(value = "Serviço responsável por salvar um dado.")
    @PostMapping
    public ResponseEntity<DadosReport> save(@RequestBody @Valid DadosReportRequest request) {
        DadosReport dados = dadosReportService.save(request.build());
        return new ResponseEntity<DadosReport>(dados, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        dadosReportService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Serviço responsável por listar todos os dados.")
    @GetMapping
    public List<DadosReport> listarTodos() {
        return dadosReportService.listarTodos();
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
    public DadosReport obterPorID(@PathVariable Long id) {
        return dadosReportService.obterPorID(id);
    }

    @GetMapping("/user/{id_usuario}")
    public List<DadosReport> listarReportsPorUsuario(@PathVariable String id_usuario) {
        return dadosReportService.listarReportsPorUsuario(id_usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosReport> update(@PathVariable("id") Long id, @RequestBody DadosReportRequest request) {
        dadosReportService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

}
