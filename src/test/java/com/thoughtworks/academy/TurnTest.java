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
        AttackManager attackManager = mock(AttackManager.class);

        Turn turn = new Turn(attackManager);
        turn.process(tom, jack);

        verify(tom, times(1)).releaseStateAttack();
        verify(tom, times(1)).getAttackList();
        verify(attackManager, times(1)).actOnProvider(tom);
        verify(attackManager, times(1)).actOnReceiver(jack);
    }

    @Test
    public void testSoliderCanAttackUseWeapon() throws Exception {
        AttackManager attackManager = new AttackManager();
        Soldier tom = new Soldier("tom");
        Player jerry = new Soldier("jerry");
        Weapon sword = new Weapon("金蛇剑", 10);
        tom.setWeapon(sword);
        jerry.setDefense(3);

        Turn turn = new Turn(attackManager);
        turn.process(tom, jerry);

        assertThat(jerry.getBlood(), is(83));
    }
}
