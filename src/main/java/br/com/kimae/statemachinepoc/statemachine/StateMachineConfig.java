package br.com.kimae.statemachinepoc.statemachine;

import java.util.EnumSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<Estados, Eventos> {

    @Override
    public void configure(StateMachineStateConfigurer<Estados, Eventos> states) throws Exception {

        states
            .withStates()
            .initial(Estados.PROPOSTA_INEXISTENTE)
            .states(EnumSet.allOf(Estados.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<Estados, Eventos> transitions) throws Exception {
        transitions
            .withExternal()
            .source(Estados.PROPOSTA_CRIADA)
            .target(Estados.ANALISE_PRE)
            .event(Eventos.ANALISAR)
            .and()

            .withExternal()
            .source(Estados.ANALISE_PRE)
            .target(Estados.APROVADO_PRE)
            .event(Eventos.APROVAR)
            .target(Estados.NEGADO_PRE)
            .event(Eventos.NEGAR)
            .and()

            .withExternal()
            .source(Estados.APROVADO_PRE)
            .target(Estados.INFOS_PESSOAIS)
            .event(Eventos.ATUALIZAR)
            .and()

            .withExternal()
            .source(Estados.INFOS_PESSOAIS)
            .target(Estados.EMAIL_VALIDADO)
            .event(Eventos.ATUALIZAR)
            .and()

            .withExternal()
            .source(Estados.EMAIL_VALIDADO)
            .target(Estados.ANALISE_POS)
            .event(Eventos.ANALISAR)
            .and()

            .withExternal()
            .source(Estados.ANALISE_POS)
            .target(Estados.NEGADO_POS)
            .event(Eventos.NEGAR)
            .target(Estados.APROVADO_POS)
            .event(Eventos.APROVAR);
    }
}
