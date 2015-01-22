package com.thoughtworks.academy.handler;

import com.thoughtworks.academy.player.Mortal;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class AdditionalAttackStateHandlerTest {

    StateAttackHandler stateAttackHandler;

    @Before
    public void setUp() throws Exception {
        stateAttackHandler = new StateAttackHandler(null);
    }

    @Test
    public void testActOnUser() throws Exception {
        Mortal bob = mock(Mortal.class);
        Mortal tom = mock(Mortal.class);

        stateAttackHandler.actOn(bob, tom);
        verify(bob, times(1)).releaseStateAttack();
    }
}
