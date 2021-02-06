package com.ziina.wallet.deposit.config;

import com.ziina.wallet.deposit.common.enums.DepositStates;
import com.ziina.wallet.deposit.common.enums.DepositTransitions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;
import java.util.Queue;

@Slf4j
@Configuration
@EnableStateMachineFactory
public class DepositStateMachineConfig extends StateMachineConfigurerAdapter<DepositStates, DepositTransitions> {
    @Override
    public void configure(StateMachineStateConfigurer<DepositStates, DepositTransitions> states) throws Exception {
        states.withStates()
                .initial(DepositStates.NEW)
                .states(EnumSet.allOf(DepositStates.class))
                .end(DepositStates.SUCCESS)
                .end(DepositStates.FUNDING_FAIL)
                .end(DepositStates.DEBIT_FAIL);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<DepositStates, DepositTransitions> transitions) throws Exception {
        Queue<Integer> q = new Queue<>();
        transitions.withExternal().source(DepositStates.NEW).target(DepositStates.FUNDED).event(DepositTransitions.FUNDING_SUCCESS)
                .and()
                .withExternal().source(DepositStates.FUNDED).target(DepositStates.DEBITED).event(DepositTransitions.DEBIT_SUCCESS)
                .and()
                .withExternal().source(DepositStates.DEBITED).target(DepositStates.SUCCESS).event(DepositTransitions.CREDIT_SUCCESS)
                .and()
                .withExternal().source(DepositStates.NEW).target(DepositStates.FUNDING_FAIL).event(DepositTransitions.FUNDING_FAIL)
                .and()
                .withExternal().source(DepositStates.FUNDED).target(DepositStates.REFUND).event(DepositTransitions.DEBIT_FAIL)
                .and()
                .withExternal().source(DepositStates.REFUND).target(DepositStates.DEBIT_FAIL).event(DepositTransitions.REFUND_SUCCESS);
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<DepositStates, DepositTransitions> config) throws Exception {
        StateMachineListenerAdapter<DepositStates, DepositTransitions> listenerAdapter = new StateMachineListenerAdapter<>(){
            @Override
            public void stateChanged(State<DepositStates, DepositTransitions> from, State<DepositStates, DepositTransitions> to) {
            }
        };

        config.withConfiguration()
                .listener(listenerAdapter);
    }
}
