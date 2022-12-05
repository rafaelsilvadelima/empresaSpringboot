package org.soulcodeacademy.empresa.repositories;

import org.soulcodeacademy.empresa.domain.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

    public List<Projeto> findByNomeContaining(String nome);

    public List<Projeto> findByOrcamentoBetween(Double orcamento1, Double orcamento2);

    public List<Projeto> findByOrcamentoGreaterThanEqual (Double orcamentoMinimo);

    public List<Projeto> findByOrcamentoLessThanEqual (Double orcamentoMaximo);

}
