package com.thoughtworks.academy;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class RoundTest {

    @Test
    public void testNewRoundWillTakeCareOfThePlayersMessage() throws Exception {
        Turn turn = mock(Turn.class);
        Player tom = mock(Player.class);
        Player bob = mock(Soldier.class);
        Round round = new Round(turn);
        round.start(tom, bob);

        verify(tom, times(1)).addListener(round);
        verify(bob, times(1)).addListener(round);
    }

    @Test
    public void testNewRound() throws Exception {
        Turn turn = mock(Turn.class);
        Player tom = new Player("tom");
        Player bob = new Player("bob");

        Round round = new Round(turn);
        round.start(tom, bob);
        verify(turn, atLeast(9)).process(tom, bob);
        verify(turn, atLeast(9)).process(bob, tom);
    }

    @Test
    public void testNewRoundListenWithPlayersDie() throws Exception {
        Turn turn = mock(Turn.class);
        Player tom = new Player("tom");
        Player bob = new Player("bob");

        Round round = new Round(turn);
        round.update(new GameMessage("die", null));
        round.start(tom, bob);
        verify(turn, never()).process(tom, bob);
        verify(turn, never()).process(bob, tom);
    }
}
