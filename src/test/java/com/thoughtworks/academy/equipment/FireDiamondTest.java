package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.Player;
import com.thoughtworks.academy.attack.FireStateAttack;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Random;

import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FireDiamond.class)
public class FireDiamondTest {

    private Player tom;
    private Player bob;
    @Before
    public void setUp() throws Exception {

        tom = mock(Player.class);
        bob = mock(Player.class);
    }

    @Test
    public void testNewFireDiamond() throws Exception {
        Random random = mock(Random.class);

        when(random.nextDouble()).thenReturn(0.1);
        whenNew(Random.class).withNoArguments().thenReturn(random);

        FireDiamond diamond = new FireDiamond();
        diamond.actOnPlayers(bob, tom);

        verify(tom, times(1)).addStateAttack(any(FireStateAttack.class));
    }

    @Test
    public void testNewFireDiamondWithoutAttack() throws Exception {
        Random random = mock(Random.class);
        Player tom = mock(Player.class);

        when(random.nextDouble()).thenReturn(0.5);
        whenNew(Random.class).withNoArguments().thenReturn(random);

        FireDiamond diamond = new FireDiamond();
        diamond.actOnPlayers(bob, tom);

        verify(tom, never()).addStateAttack(any(FireStateAttack.class));
    }
}