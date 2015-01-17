package com.thoughtworks.academy;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TurnTest {

    @Test
    public void testTurn() throws Exception {
        Player tom = mock(Player.class);
        Soldier jack = mock(Soldier.class);
        PhysicalAttackHandler physicalAttackHandler = mock(PhysicalAttackHandler.class);

        Turn turn = new Turn(physicalAttackHandler);
        turn.process(tom, jack);

        verify(tom, times(1)).releaseStateAttack();
        verify(tom, times(1)).getAttackList();
        verify(physicalAttackHandler, times(1)).actOnPlayer(tom, jack);
    }

    @Test
    public void testSoliderCanAttackUseWeapon() throws Exception {
        PhysicalAttackHandler physicalAttackHandler = new PhysicalAttackHandler();
        Soldier tom = new Soldier("tom");
        Player jerry = new Soldier("jerry");
        Weapon sword = new Weapon("金蛇剑", 10);
        tom.setWeapon(sword);
        jerry.setDefense(3);

        Turn turn = new Turn(physicalAttackHandler);
        turn.process(tom, jerry);

        assertThat(jerry.getBlood(), is(83));
    }
}
