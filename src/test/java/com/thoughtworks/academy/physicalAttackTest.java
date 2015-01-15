package com.thoughtworks.academy;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class physicalAttackTest {

    @Test
    public void testPhysicalAttackActOnReceiver() throws Exception {
        Player tom = new Player("tom");

        PhysicalAttack physicalAttack = new PhysicalAttack();

        assertThat(physicalAttack.getAttack(), is(10));

        assertThat(tom.getBlood(), is(100));
        physicalAttack.actOnReceiver(tom);
        assertThat(tom.getBlood(), is(90));
    }

    @Test
    public void testPhysicalAttackWithSpecifyValue() throws Exception {
        PhysicalAttack physicalAttack = new PhysicalAttack(5);

        assertThat(physicalAttack.getAttack(), is(5));
    }

    @Test
    public void testBodyAttackWillEffectByDefense() throws Exception {
        Player tom = new Soldier("tom");

        tom.setDefense(5);
        PhysicalAttack physicalAttack = new PhysicalAttack();

        assertThat(physicalAttack.getAttack(), is(10));
        assertThat(tom.getBlood(), is(100));
        physicalAttack.actOnReceiver(tom);
        assertThat(tom.getBlood(), is(95));
    }

    @Test
    public void testBodyAttackCantLessThanDefense() throws Exception {
        Player tom = new Soldier("tom");

        tom.setDefense(50);
        PhysicalAttack physicalAttack = new PhysicalAttack();

        assertThat(physicalAttack.getAttack(), is(10));
        assertThat(tom.getBlood(), is(100));
        physicalAttack.actOnReceiver(tom);
        assertThat(tom.getBlood(), is(100));
    }
}
