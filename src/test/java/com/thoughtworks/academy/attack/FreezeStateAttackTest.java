package com.thoughtworks.academy.attack;

import com.thoughtworks.academy.Player;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class FreezeStateAttackTest {
    FreezeStateAttack freezeStateAttack;

    @Before
    public void setUp() throws Exception {

        freezeStateAttack = new FreezeStateAttack();
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testActOnReceiver() throws Exception {

        Player tom = mock(Player.class);

        freezeStateAttack.actOnReceiver(tom);
        verify(tom, times(1)).lock();
        freezeStateAttack.actOnReceiver(tom);
        verify(tom, times(1)).lock();
        freezeStateAttack.actOnReceiver(tom);
        verify(tom, times(2)).lock();

        freezeStateAttack.actOnReceiver(tom);
        freezeStateAttack.actOnReceiver(tom);
        freezeStateAttack.actOnReceiver(tom);
        verify(tom, times(3)).lock();
        verify(tom, times(1)).addStateAttack(null);

        freezeStateAttack.actOnReceiver(tom);
        freezeStateAttack.actOnReceiver(tom);
        freezeStateAttack.actOnReceiver(tom);
        verify(tom, times(3)).lock();
    }
}