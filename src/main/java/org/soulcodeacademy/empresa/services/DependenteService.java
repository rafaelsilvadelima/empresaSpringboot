package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.controllers.errors.CustomErrorResponse;
import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.dto.DependenteDTO;
import org.soulcodeacademy.empresa.repositories.DependenteRepository;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.soulcodeacademy.empresa.services.errors.ParametrosInsuficientesError;
import org.soulcodeacademy.empresa.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DependenteService {

    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private EmpregadoService empregadoService;

    public List<Dependente> listar(){
        return this.dependenteRepository.findAll();
    }

    public Dependente buscarPorId(Integer id){
        return this.dependenteRepository.findById(id).orElseThrow(
                () -> new RecursoNaoEncontradoError("Não foi localizado dependente com o id " + id + "!")
        );
    }

    //Este método retorna uma lista de dependentes pq um responsável pode ter mais de um dependente.
    public List<Dependente> buscarPorIdResponsavel(Integer idResponsavel) {
        return this.dependenteRepository.findAllByResponsavelId(idResponsavel);
    }

    public Dependente salvar(DependenteDTO dto) {
        Empregado responsavel = this.empregadoService.buscarPorId(dto.getIdResponsavel());
        Dependente novoDependente = new Dependente(null, dto.getNome(), dto.getIdade());
        novoDependente.setResponsavel(responsavel);
        return this.dependenteRepository.save(novoDependente);
    }

    public Dependente atualizar(Integer id, DependenteDTO dto){
        if(id == null) {
            throw new ParametrosInsuficientesError("É preciso informar o id do dependente que deseja atualizar!");
        } else {
            this.buscarPorId(id); //busca se existe Dependente cadastrado com este id e interrompe o método caso não encontre.
            Empregado responsavel = this.empregadoService.buscarPorId(dto.getIdResponsavel());
            Dependente dependenteAtualizado = new Dependente(id, dto.getNome(), dto.getIdade());
            dependenteAtualizado.setResponsavel(responsavel);
            return this.dependenteRepository.save(dependenteAtualizado);
        }

    }

    //Não há método para deletar dependentes pois a exclusão pode causar conflito com outras entidades já persistidas.


}
