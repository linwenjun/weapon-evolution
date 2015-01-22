package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.player.Mortal;
import com.thoughtworks.academy.additionalAttackState.FireAttackAdditionalState;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FireDiamond.class)

public class FireDiamondTest {

    private Mortal tom;
    private Mortal bob;
    @Before
    public void setUp() throws Exception {

        tom = mock(Mortal.class);
        bob = mock(Mortal.class);
    }

    @Test
    public void testNewFireDiamond() throws Exception {
        FireDiamond diamond = new FireDiamond();
        diamond.actOnPlayers(bob, tom);

        verify(tom, times(1)).attachAttackState(any(FireAttackAdditionalState.class));
    }
}