package com.thoughtworks.academy.additionalAttackState;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BlankAttackStateTest {

    @Test
    public void testType() throws Exception {
        AdditionalAttackState blankAttackState = new BlankAttackState();
        assertThat(blankAttackState.getType(), is("blank"));
    }

    @Test
    public void testTurn() throws Exception {

        AdditionalAttackState blankAttackState1 = new BlankAttackState();
        AdditionalAttackState blankAttackState2 = new BlankAttackState();

        AdditionalAttackState actual = blankAttackState1.turn(blankAttackState2);

        assertThat(actual, is(blankAttackState1));
    }
}
