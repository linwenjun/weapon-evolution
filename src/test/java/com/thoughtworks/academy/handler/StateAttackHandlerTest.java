package com.thoughtworks.academy.handler;

import com.thoughtworks.academy.Player;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class StateAttackHandlerTest {

    StateAttackHandler stateAttackHandler;

    @Before
    public void setUp() throws Exception {
        stateAttackHandler = new StateAttackHandler(null);
    }

    @Test
    public void testActOnUser() throws Exception {
        Player bob = mock(Player.class);
        Player tom = mock(Player.class);

        stateAttackHandler.actOn(bob, tom);
        verify(bob, times(1)).releaseStateAttack();
    }
}
