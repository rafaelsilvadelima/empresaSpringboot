package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.dto.ProjetoDTO;
import org.soulcodeacademy.empresa.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping("/projetos")
    public List<Projeto> listar() {
        return this.projetoService.listar();
    }

    @GetMapping("/projetos/id/{id}")
    public Projeto buscarPorId(@PathVariable Integer id) {
        return this.projetoService.buscarPorId(id);
    }

    @GetMapping("/projetos/nome/{nome}")
    public List<Projeto> buscarPorNomeContendo(@PathVariable String nome) {
        return this.projetoService.buscarPorNomeContendo(nome);
    }

    @GetMapping("/projetos/buscarporfaixaorcamentaria/{orcamentominimo}/{orcamentomaximo}")
    public List<Projeto> buscarPorFaixaOrcamentaria(@PathVariable("orcamentominimo") Double orcamentoMinimo, @PathVariable("orcamentomaximo") Double orcamentoMaximo) {
        return this.projetoService.buscarPorFaixaOrcamentaria(orcamentoMinimo, orcamentoMaximo);
    }

    @GetMapping("/projetos/orcamentominimo/{orcamentominimo}")
    public List<Projeto> buscarPorOrcamentoMinimo(@PathVariable("orcamentominimo") Double orcamentoMinimo) {
        return this.projetoService.buscarPorOrcamentoMinimo(orcamentoMinimo);
    }

    @GetMapping("/projetos/orcamentomaximo/{orcamentomaximo}")
    public List<Projeto> buscarPorOrcamentoMaximo(@PathVariable("orcamentomaximo") Double orcamentoMaximo) {
        return this.projetoService.buscarPorOrcamentoMaximo(orcamentoMaximo);
    }

    @PostMapping("/projetos")
    public Projeto salvar(@RequestBody @Valid ProjetoDTO dto) {
        return this.projetoService.salvar(dto);
    }

    @PutMapping("/projetos")
    public Projeto atualizar(@PathVariable Integer id, @RequestBody @Valid ProjetoDTO dto) {
        return this.projetoService.atualizar(id, dto);
    }

    //Não há método para deletar projetos pois a exclusão pode causar conflito com outras entidades já persistidas.
}

