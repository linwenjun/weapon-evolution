package com.thoughtworks.academy;

import com.thoughtworks.academy.handler.GameHandler;
import com.thoughtworks.academy.handler.PhysicalAttackHandler;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TurnTest {

    @Test
    public void testTurn() throws Exception {
        Player tom = mock(Player.class);
        Soldier jack = mock(Soldier.class);
        PhysicalAttackHandler physicalAttackHandler = mock(PhysicalAttackHandler.class);

        Turn turn = new Turn(physicalAttackHandler);
        turn.process(tom, jack);

        verify(physicalAttackHandler, times(1)).actOn(tom, jack);
    }

    @Test
    public void testProviderWillUnlockAfterTurn() throws Exception {
        Player tom = mock(Player.class);
        Soldier jack = mock(Soldier.class);
        GameHandler gameHandler = mock(GameHandler.class);

        Turn turn = new Turn(gameHandler);
        turn.process(tom, jack);
        verify(tom).restore();
    }
}
