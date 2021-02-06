package com.ziina.wallet.deposit.config;

import com.ziina.wallet.deposit.common.enums.DepositStates;
import com.ziina.wallet.deposit.common.enums.DepositTransitions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

import static com.ziina.wallet.deposit.common.enums.DepositTransitions.FUNDING_SUCCESS;
import static com.ziina.wallet.deposit.common.enums.DepositTransitions.REFUND_SUCCESS;

@SpringBootTest
class DepositStateMachineConfigTest {

    @Autowired
    StateMachineFactory<DepositStates, DepositTransitions> factory;

    @Test
    public void testStateMachine(){
        StateMachine<DepositStates, DepositTransitions> stateMachine = factory.getStateMachine();
        stateMachine.start();
        System.out.println(stateMachine.getState());
        stateMachine.sendEvent(REFUND_SUCCESS);
        System.out.println(stateMachine.getState());
        stateMachine.sendEvent(FUNDING_SUCCESS);
        System.out.println(stateMachine.getState());

    }
}