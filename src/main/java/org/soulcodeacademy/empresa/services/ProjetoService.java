package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.dto.ProjetoDTO;
import org.soulcodeacademy.empresa.repositories.ProjetoRepository;
import org.soulcodeacademy.empresa.services.errors.ParametrosInsuficientesError;
import org.soulcodeacademy.empresa.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> listar() {
        return this.projetoRepository.findAll();
    }

    public Projeto buscarPorId(Integer id) {
        if(id == null) {
            throw new ParametrosInsuficientesError("É preciso informar o id do projeto!");
        } else {
            return this.projetoRepository.findById(id).orElseThrow(
                    () -> new RecursoNaoEncontradoError("Não foi encontrado projeto com o id " + id + "!")
            );
        }

    }

    public List<Projeto> buscarPorNomeContendo(String nome) {
        return this.projetoRepository.findByNomeContaining(nome);
    }

    public List<Projeto> buscarPorFaixaOrcamentaria(Double orcamentoMinimo, Double orcamentoMaximo) {
        return this.projetoRepository.findByOrcamentoBetween(orcamentoMinimo, orcamentoMaximo);
    }

    public List<Projeto> buscarPorOrcamentoMinimo(Double orcamentoMinimo) {
        return this.projetoRepository.findByOrcamentoGreaterThanEqual(orcamentoMinimo);
    }

    public List<Projeto> buscarPorOrcamentoMaximo(Double orcamentoMaximo) {
        return this.projetoRepository.findByOrcamentoLessThanEqual(orcamentoMaximo);
    }

    public Projeto salvar(ProjetoDTO dto) {
        Projeto novoProjeto = new Projeto(null, dto.getNome(), dto.getOrcamento(), dto.getDescricao());
        return this.projetoRepository.save(novoProjeto);
    }

    public Projeto atualizar(Integer id, ProjetoDTO dto) {
        Projeto projetoAtualizado = this.buscarPorId(id); //busca se existe Projeto cadastrado com este id e interrompe o método caso não encontre.
        projetoAtualizado.setNome(dto.getNome());
        projetoAtualizado.setOrcamento(dto.getOrcamento());
        projetoAtualizado.setDescricao(dto.getDescricao());
        return this.projetoRepository.save(projetoAtualizado);
    }

    //Não há método para deletar projetos pois a exclusão pode causar conflito com outras entidades já persistidas.

}
