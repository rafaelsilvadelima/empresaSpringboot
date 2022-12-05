package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.dto.EnderecoDTO;
import org.soulcodeacademy.empresa.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/enderecos")
    public List<Endereco> listar() {
        return this.enderecoService.listar();
    }

    @GetMapping("/enderecos/{id}")
    public Endereco buscarPorId(@PathVariable Integer id) {
        return this.enderecoService.buscarPorId(id);
    }

    @PostMapping("/enderecos")
    public Endereco salvar(@RequestBody @Valid EnderecoDTO dto) {
        return this.enderecoService.salvar(dto);
    }

    @PutMapping("/enderecos")
    public Endereco atualizar(@PathVariable Integer id, @RequestBody @Valid EnderecoDTO dto) {
        return this.enderecoService.atualizar(id, dto);
    }

}
