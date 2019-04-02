package br.com.kimae.statemachinepoc.service.proposta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kimae.statemachinepoc.entity.Proposta;
import br.com.kimae.statemachinepoc.repository.IPropostaRepository;

@Service
public class BuscarPropostasService {

    @Autowired
    private IPropostaRepository repository;

    public List<Proposta> executar() {
        return repository.findAll();
    }
}
