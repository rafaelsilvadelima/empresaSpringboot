package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.soulcodeacademy.empresa.services.errors.ParametrosInsuficientesError;
import org.soulcodeacademy.empresa.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpregadoService {

    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ProjetoService projetoService;

    public List<Empregado> listar(){
        return this.empregadoRepository.findAll();
    }

    public Empregado buscarPorId(Integer id) {
        if(id == null) {
            throw new ParametrosInsuficientesError("É preciso informar o id do empregado que deseja atualizar!");
        } else {
            return this.empregadoRepository.findById(id).orElseThrow(
                    () -> new RecursoNaoEncontradoError("Não foi encontrado Empregado com o id "+ id + "!")
            );
        }

    }

    public List<Empregado> buscarPorNomeContendo(String nome) {
        return this.empregadoRepository.findByNomeContaining(nome);
    }

    public Empregado salvar(EmpregadoDTO dto) {
        Empregado novoEmpregado = new Empregado(dto.getNome(), dto.getEmail(), dto.getSalario(), dto.getSenha());
        Endereco endereco = this.enderecoService.buscarPorId(dto.getIdEndereco());
        novoEmpregado.setEndereco(endereco);
        return this.empregadoRepository.save(novoEmpregado);
    }

    public Empregado atualizar(Integer id, EmpregadoDTO dto) {
        if(dto.getIdEndereco() == 0 || dto.getIdEndereco() == null){
            throw new ParametrosInsuficientesError("É preciso informar o id do endereço do empregado!");
        } else {
            Empregado empregadoAtualizado = this.buscarPorId(id); //busca se existe Empregado cadastrado com este id e interrompe o método caso não encontre.
            Endereco endereco = this.enderecoService.buscarPorId(dto.getIdEndereco());
            empregadoAtualizado.setEndereco(endereco);
            empregadoAtualizado.setEmail(dto.getEmail());
            empregadoAtualizado.setNome(dto.getNome());
            empregadoAtualizado.setSalario(dto.getSalario());
            return this.empregadoRepository.save(empregadoAtualizado);
        }

    }

    public  Empregado inserirProjeto(Integer idEmpregado, Integer idProjeto) {
        Empregado empregadoInserirProjeto = this.buscarPorId(idEmpregado); //busca se existe Empregado cadastrado com este id e interrompe o método caso não encontre.
        Projeto projeto = this.projetoService.buscarPorId(idProjeto); //busca se existe Projeto cadastrado com este id e interrompe o método caso não encontre.
        empregadoInserirProjeto.getProjetos().add(projeto);
        return this.empregadoRepository.save(empregadoInserirProjeto);
    }

    public Empregado atualizarSenha(Integer id, String senha) {
        Empregado empregadoComSenhaAtualizada = this.buscarPorId(id); //busca se existe Empregado cadastrado com este id e interrompe o método caso não encontre.
        empregadoComSenhaAtualizada.setSenha(senha);
        return this.empregadoRepository.save(empregadoComSenhaAtualizada);
    }


    //Não há método para deletar empregados pois a exclusão pode causar conflito com outras entidades já persistidas.


}
