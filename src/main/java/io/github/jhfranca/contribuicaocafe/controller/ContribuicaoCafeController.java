package io.github.jhfranca.contribuicaocafe.controller;

import io.github.jhfranca.contribuicaocafe.dto.SalvarContribuicaoResponse;
import io.github.jhfranca.contribuicaocafe.entity.ContribuicaoCafe;
import io.github.jhfranca.contribuicaocafe.service.ContribuicaoCafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contribuicoes")
public class ContribuicaoCafeController {

    @Autowired
    private ContribuicaoCafeService service;

    @PostMapping
    public ResponseEntity<SalvarContribuicaoResponse> cadastrarContribuicaoCafe(@RequestBody ContribuicaoCafe contribuicaoCafe){
        return ResponseEntity.ok(service.save(contribuicaoCafe));
    }

    @GetMapping("{id}")
    public ContribuicaoCafe buscarPorId(@PathVariable("id") Long id) throws NotFoundException {
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable("id") Long id){
        service.delete(id);

        return ResponseEntity.ok(
                String.format("A contribuição %s foi deletada com sucesso", id.toString())
        );
    }

    @PutMapping
    public ResponseEntity<SalvarContribuicaoResponse> atualizar(@RequestBody ContribuicaoCafe contribuicaoCafe) throws NotFoundException {
        return ResponseEntity.ok(
                service.update(contribuicaoCafe)
        );
    }

    @GetMapping
    public ResponseEntity<List<ContribuicaoCafe>> buscarTodos(){
        return ResponseEntity.ok(service.findAll());
    }
}
