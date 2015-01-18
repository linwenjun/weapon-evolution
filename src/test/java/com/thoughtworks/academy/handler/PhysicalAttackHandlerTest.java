package com.thoughtworks.academy.handler;

import com.thoughtworks.academy.Player;
import com.thoughtworks.academy.Weapon;
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

    @Before
    public void setUp() throws Exception {
        physicalAttackHandler = new PhysicalAttackHandler(null);


    }

    @Test
    public void testMainTaskOfPhysicalAttackHandler() throws Exception {

        Player tom = mock(Player.class);
        Player bob = mock(Player.class);
        when(tom.getAttack()).thenReturn(10);

        physicalAttackHandler.actOnPlayers(tom, bob);

        verify(bob, times(1)).beenAttack(10);
    }

    @Test
    public void testPhysicalAttackWithWeapon() throws Exception {

        Weapon sword = mock(Weapon.class);
        Player tom = mock(Player.class);
        Player bob = mock(Player.class);
        when(sword.getAttackValue()).thenReturn(5);
        when(tom.getAttack()).thenReturn(10);
        when(tom.getWeapon()).thenReturn(sword);

        physicalAttackHandler.actOn(tom, bob);

        verify(bob, times(1)).beenAttack(15);
    }

    @Test
    public void testWillExecuteSuccessor() throws Exception {

        GameHandler handler = mock(GameHandler.class);
        Player tom = mock(Player.class);
        Player bob = mock(Player.class);
        when(tom.getBlood()).thenReturn(10);
        when(bob.getBlood()).thenReturn(10);

        physicalAttackHandler = new PhysicalAttackHandler(handler);
        physicalAttackHandler.actOn(tom, bob);

        verify(handler, times(1)).actOn(tom, bob);
    }
}
