package br.com.kimae.statemachinepoc.service.proposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kimae.statemachinepoc.entity.Proposta;
import br.com.kimae.statemachinepoc.repository.IPropostaRepository;

@Service
public class BuscarPropostaPorIdService {

    @Autowired
    private IPropostaRepository repository;

    public Proposta executar(Long id) {
        return repository.findById(id);
    }
}
