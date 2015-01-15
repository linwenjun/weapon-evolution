package com.thoughtworks.academy;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FireStateAttackTest {
    @Test
    public void testFireStateAttack() throws Exception {

        FireStateAttack fireStateAttack = new FireStateAttack();
        Player tom = new Player("tom");
        tom.addStateAttack(fireStateAttack);

        tom.releaseStateAttack();
        assertThat(tom.getBlood(), is(95));

        tom.releaseStateAttack();
        tom.releaseStateAttack();
        assertThat(tom.getBlood(), is(85));

        tom.releaseStateAttack();
        assertThat(tom.getBlood(), is(85));
    }

    @Test
    public void testMultipleFireStateAttack() throws Exception {

        FireStateAttack fireStateAttack = new FireStateAttack();
        Player tom = new Player("tom");
        tom.addStateAttack(fireStateAttack);

        tom.releaseStateAttack();
        assertThat(tom.getBlood(), is(95));

        fireStateAttack.update(new FireStateAttack());
        tom.releaseStateAttack();
        tom.releaseStateAttack();
        assertThat(tom.getBlood(), is(75));

        tom.releaseStateAttack();
        assertThat(tom.getBlood(), is(70));

        tom.releaseStateAttack();
        assertThat(tom.getBlood(), is(70));
    }
}