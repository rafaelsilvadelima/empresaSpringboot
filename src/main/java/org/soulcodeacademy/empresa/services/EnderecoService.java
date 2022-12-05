package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.dto.EnderecoDTO;
import org.soulcodeacademy.empresa.repositories.EnderecoRepository;
import org.soulcodeacademy.empresa.services.errors.ParametrosInsuficientesError;
import org.soulcodeacademy.empresa.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listar() {
        return this.enderecoRepository.findAll();
    }

    public Endereco buscarPorId(Integer id) {
        if(id == null) {
            throw new ParametrosInsuficientesError("É preciso informar o id do endereço");
        } else {
            return this.enderecoRepository.findById(id).orElseThrow(
                    () -> new RecursoNaoEncontradoError("Não foi encontrado endereço com o id " + id + "!")
            );
        }

    }

    public Endereco salvar(EnderecoDTO dto){
        Endereco novoEndereco = new Endereco(null, dto.getCidade(), dto.getUf());
        return this.enderecoRepository.save(novoEndereco);
    }

    public Endereco atualizar(Integer id, EnderecoDTO dto) {
        Endereco enderecoAtualizado = this.buscarPorId(id); //busca se existe Endereço cadastrado com este id e interrompe o método caso não encontre.
        return  this.enderecoRepository.save(enderecoAtualizado);
    }

    //Não há método para deletar endereços pois a exclusão pode causar conflito com outras entidades já persistidas.

}
