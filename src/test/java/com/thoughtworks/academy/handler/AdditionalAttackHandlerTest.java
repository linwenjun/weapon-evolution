package com.thoughtworks.academy.handler;

import com.thoughtworks.academy.attack.FireStateAttack;
import com.thoughtworks.academy.Player;
import org.junit.Test;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

public class AdditionalAttackHandlerTest {

    @Test
    public void testFireAttackActOnReceiver() throws Exception {
        Player bob = mock(Player.class);
        Player tom = mock(Player.class);

        AdditionalAttackHandler additionalAttackHandler = new AdditionalAttackHandler(null);
        additionalAttackHandler.actOn(bob, tom);

        verify(tom, times(1)).addStateAttack((FireStateAttack) anyObject());
    }
}
