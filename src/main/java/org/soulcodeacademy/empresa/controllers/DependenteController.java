package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.dto.DependenteDTO;
import org.soulcodeacademy.empresa.services.DependenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DependenteController {

    @Autowired
    private DependenteService dependenteService;

    @GetMapping("/dependentes")
    public List<Dependente> listar() {
        return this.dependenteService.listar();
    }

    @GetMapping("/dependentes/{id}")
    public Dependente buscarPorId(@PathVariable  Integer id) {
        return this.dependenteService.buscarPorId(id);
    }

    @GetMapping("/dependentes/responsaveis/{idresponsavel}")
    public List<Dependente> buscarPorIdResponsavel(@PathVariable("idresponsavel") Integer idResponsavel) {
        return this.dependenteService.buscarPorIdResponsavel(idResponsavel);
    }

    @PostMapping("/dependentes")
    public Dependente salvar(@RequestBody @Valid DependenteDTO dto) {
        return this.dependenteService.salvar(dto);
    }

    @PutMapping("/dependentes/{id}")
    public Dependente atualizar(@PathVariable Integer id, @RequestBody @Valid DependenteDTO dto) {
      return this.dependenteService.atualizar(id, dto);
    }

}
