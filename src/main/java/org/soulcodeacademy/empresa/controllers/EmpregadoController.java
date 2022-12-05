package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.services.EmpregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmpregadoController {

    @Autowired
    private EmpregadoService empregadoService;

    @GetMapping("/empregados")
    public List<Empregado> listar() {
        return this.empregadoService.listar();
    }

    @GetMapping("/empregados/{id}")
    public Empregado buscarPorId(@PathVariable Integer id) {
        return this.empregadoService.buscarPorId(id);
    }

    @GetMapping("/empregados/nome/{nome}")
    public List<Empregado> buscarPorNomeContendo(@PathVariable String nome) {
        return this.empregadoService.buscarPorNomeContendo(nome);
    }

    @PostMapping("/empregados")
    public Empregado salvar(@RequestBody @Valid EmpregadoDTO dto) {
        return this.empregadoService.salvar(dto);
    }

    @PutMapping("/empregados/{id}")
    public Empregado atualizar(@PathVariable Integer id, @RequestBody @Valid EmpregadoDTO dto) {
        return this.empregadoService.atualizar(id, dto);
    }

    @PutMapping("/empregados/{idempregado}/{idprojeto}")
    public Empregado inserirProjeto(@PathVariable("idempregado") Integer idEmpregado, @PathVariable("idprojeto") Integer idProjeto) {
        return this.empregadoService.inserirProjeto(idEmpregado, idProjeto);
    }
    @PostMapping("/empregados/{id}/{password}")
    public Empregado atualizarSenha(@PathVariable("id") Integer id, @PathVariable("password") String senha) {
        return this.empregadoService.atualizarSenha(id, senha);
    }
}
