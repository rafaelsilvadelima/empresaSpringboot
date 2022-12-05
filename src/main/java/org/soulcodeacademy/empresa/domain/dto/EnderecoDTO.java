package org.soulcodeacademy.empresa.domain.dto;

import javax.validation.constraints.NotBlank;

public class EnderecoDTO {

    @NotBlank(message = "É obrigatório informar a cidade do endereço!")
    private String cidade;

    @NotBlank(message = "É obrigatório informar a UF do endereço!")
    private String uf;



    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
