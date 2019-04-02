package br.com.kimae.statemachinepoc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kimae.statemachinepoc.entity.Proposta;
import br.com.kimae.statemachinepoc.service.proposta.BuscarPropostasService;
import br.com.kimae.statemachinepoc.service.proposta.SalvarPropostaService;

@RequestMapping("/proposta")
@RestController
public class PropostaController {

    @Autowired
    private SalvarPropostaService salvarPropostaService;

    @Autowired
    private BuscarPropostasService buscarPropostasService;

    @PostMapping
    public void salvar(@RequestBody Proposta proposta) {
        salvarPropostaService.executar(proposta);
    }

    @GetMapping
    public List<Proposta> buscar() {
        return buscarPropostasService.executar();
    }
}

