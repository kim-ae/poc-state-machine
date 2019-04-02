package br.com.kimae.statemachinepoc.service.proposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kimae.statemachinepoc.entity.Proposta;
import br.com.kimae.statemachinepoc.repository.IPropostaRepository;

@Service
public class SalvarPropostaService {

    @Autowired
    private IPropostaRepository repository;

    public void executar(Proposta proposta) {
        repository.save(proposta);
    }
}
