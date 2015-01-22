package com.thoughtworks.academy;

import com.thoughtworks.academy.player.OrdinaryPlayer;
import com.thoughtworks.academy.handler.GameHandler;
import com.thoughtworks.academy.handler.PhysicalAttackHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Round.class)
public class RoundTest {

    @Test
    public void testNewRound() throws Exception {
        PhysicalAttackHandler handler = mock(PhysicalAttackHandler.class);
        OrdinaryPlayer tom = mock(OrdinaryPlayer.class);
        OrdinaryPlayer bob = mock(OrdinaryPlayer.class);

        whenNew(PhysicalAttackHandler.class).withAnyArguments().thenReturn(handler);
        whenNew(Turn.class).withAnyArguments().thenReturn(mock(Turn.class));
        new Round(tom, bob);

        verifyNew(PhysicalAttackHandler.class).withArguments(any(GameHandler.class));
        verifyNew(Turn.class).withArguments(any(GameHandler.class));
    }

    @Test
    public void testRoundStart() throws Exception {
        PhysicalAttackHandler handler = mock(PhysicalAttackHandler.class);
        Turn turn = mock(Turn.class);
        OrdinaryPlayer tom = mock(OrdinaryPlayer.class);
        OrdinaryPlayer bob = mock(OrdinaryPlayer.class);

        whenNew(PhysicalAttackHandler.class).withAnyArguments().thenReturn(handler);
        whenNew(Turn.class).withAnyArguments().thenReturn(turn);
        Round round = new Round(tom, bob);

        round.start();

        verify(turn, atLeast(9)).process(tom, bob);
        verify(turn, atLeast(9)).process(bob, tom);
    }
}
