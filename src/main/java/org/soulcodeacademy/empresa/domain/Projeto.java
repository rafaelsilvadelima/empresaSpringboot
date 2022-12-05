package org.soulcodeacademy.empresa.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String nome;

    @Column(nullable = false)
    private Double orcamento;

    private String descricao;

    public Projeto() { }

    public Projeto(Integer id, String nome, Double orcamento, String descricao) {
        this.id = id;
        this.nome = nome;
        this.orcamento = orcamento;
        this.descricao = descricao;
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

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Projeto projeto)) return false;
        return getId().equals(projeto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
