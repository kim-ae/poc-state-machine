package br.com.kimae.statemachinepoc.listener;

import static java.util.Objects.nonNull;

import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomStateMachineListener extends StateMachineListenerAdapter<String, String> {

    @Override
    public void stateChanged(State<String, String> from, State<String, String> to) {
        log.info("State changed: [{}] > [{}]",
            nonNull(from) ? from.getIds() : "-",
            nonNull(to) ? to.getIds() : "-");
    }

    @Override
    public void stateMachineStarted(StateMachine<String, String> stateMachine) {
        final Long numeroProposta = stateMachine.getExtendedState().get("numeroProposta", Long.class);
        log.info("StateMachine started: [numeroProposta:{}]", numeroProposta);
    }

    @Override
    public void stateMachineStopped(StateMachine<String, String> stateMachine) {
        final Long numeroProposta = stateMachine.getExtendedState().get("numeroProposta", Long.class);
        log.info("StateMachine stopped: [numeroProposta:{}]", numeroProposta);
    }

    @Override
    public void extendedStateChanged(Object key, Object value) {
        log.info("StateMachine variable added: [key:{}]", key);
    }


}
