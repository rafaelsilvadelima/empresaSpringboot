package org.soulcodeacademy.empresa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Empregado {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String nome;

    @Column(length = 150, nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Double salario;

    @Column(nullable = false)
    private String senha;

    @OneToOne
    @JoinColumn(nullable = false, name = "id_endereco")
    private Endereco endereco;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Projeto> projetos = new ArrayList<>();

    public Empregado() {}

    public Empregado(String nome, String email, Double salario, String senha) {
        this.nome = nome;
        this.email = email;
        this.salario = salario;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Projeto> getProjetos() { return projetos; }

    public void setProjetos(List<Projeto> projetos) { this.projetos = projetos; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }
}
