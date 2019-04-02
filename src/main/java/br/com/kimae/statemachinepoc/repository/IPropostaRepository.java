package br.com.kimae.statemachinepoc.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.kimae.statemachinepoc.entity.Proposta;

public interface IPropostaRepository extends Repository<Proposta, Long> {

    List<Proposta> findAll();

    Proposta findById(Long id);

    void save(Proposta proposta);

}
