package org.soulcodeacademy.empresa.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmpregadoDTO {

    @NotBlank(message = "É obrigatório informar o nome do Empregado!")
    private String nome;

    @NotBlank(message = "É obrigatório informar o e-mail do Empregado!")
    private String email;

    @NotNull(message = "É obrigatório informar o salário do Empregado!")
    private Double salario;

    @NotBlank(message = "É obrigatório informar a senha do Empregado!")
    private String senha;

    @NotNull(message = "É obrigatório informar o endereço do Empregado!")
    private Integer idEndereco;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }
}
