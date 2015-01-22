package com.thoughtworks.academy.handler;

import com.thoughtworks.academy.player.Mortal;
import com.thoughtworks.academy.equipment.Weapon;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.*;


@PrepareForTest(PhysicalAttackHandler.class)
@RunWith(PowerMockRunner.class)
public class PhysicalAttackHandlerTest {
    PhysicalAttackHandler physicalAttackHandler;
    Mortal tom;
    Mortal bob;

    @Before
    public void setUp() throws Exception {
        physicalAttackHandler = new PhysicalAttackHandler(null);
        tom = mock(Mortal.class);
        bob = mock(Mortal.class);
    }

    @Test
    public void testMainTaskOfPhysicalAttackHandler() throws Exception {
        when(tom.getAttack()).thenReturn(10);

        physicalAttackHandler.actOnPlayers(tom, bob);

        verify(bob, times(1)).beenAttack(10);
    }

    @Test
    public void testPhysicalAttackWithWeapon() throws Exception {

        Weapon sword = mock(Weapon.class);
        when(sword.getAttackValue()).thenReturn(5);
        when(tom.getAttack()).thenReturn(10);
        when(tom.getWeapon()).thenReturn(sword);

        physicalAttackHandler.actOn(tom, bob);

        verify(bob, times(1)).beenAttack(15);
    }

    @Test
    public void testWillExecuteSuccessor() throws Exception {
        GameHandler handler = mock(GameHandler.class);
        when(tom.getBlood()).thenReturn(10);
        when(bob.getBlood()).thenReturn(10);

        physicalAttackHandler = new PhysicalAttackHandler(handler);
        physicalAttackHandler.actOn(tom, bob);

        verify(handler, times(1)).actOn(tom, bob);
    }

    @Test
    public void testHandleWillNotExcuteWillProviderWasLocked() throws Exception {

        when(tom.isExhausted()).thenReturn(true);

        physicalAttackHandler.actOnPlayers(tom, bob);

        verify(bob, never()).beenAttack(anyInt());
    }
}
