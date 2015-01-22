package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.player.OrdinaryPlayer;
import com.thoughtworks.academy.additionalAttackState.FreezeAttackAdditionalState;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FreezeDiamond.class)
public class FreezeDiamondTest {
    private OrdinaryPlayer tom;
    private OrdinaryPlayer bob;
    private FreezeDiamond freezeDiamond;

    @Before
    public void setUp() throws Exception {

        tom = mock(OrdinaryPlayer.class);
        bob = mock(OrdinaryPlayer.class);
        freezeDiamond = new FreezeDiamond();
    }


    @Test
    public void testActOnReceiver() throws Exception {
        freezeDiamond.actOnPlayers(bob, tom);
        verify(tom, times(1)).attachAttackState(any(FreezeAttackAdditionalState.class));
    }
}