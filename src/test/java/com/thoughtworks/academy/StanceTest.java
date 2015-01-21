package com.thoughtworks.academy;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StanceTest {

    Stance stance;
    Stance stance2;

    @Before
    public void setUp() throws Exception {
        stance = new Stance();
        stance2 = new Stance();
    }

    @Test
    public void testNewBackground() throws Exception {

        assertThat(stance.getPosition(), is(0));
        assertThat(stance2.getPosition(), is(1));
    }

    @Test
    public void testStepForward() throws Exception {

        stance.stepForward();
        stance2.stepForward();
        assertThat(stance.getPosition(), is(1));
        assertThat(stance2.getPosition(), is(0));
    }

    @Test
    public void testStepBack() throws Exception {

        stance.stepBack();
        stance2.stepBack();
        assertThat(stance.getPosition(), is(-1));
        assertThat(stance2.getPosition(), is(2));
    }

    @Test
    public void testGetDistance() throws Exception {

        assertThat(stance.getDistance(stance2), is(1));

        stance.stepBack();
        assertThat(stance.getDistance(stance2), is(2));
        assertThat(stance2.getDistance(stance), is(2));
    }
}