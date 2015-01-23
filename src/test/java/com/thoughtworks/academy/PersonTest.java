package com.thoughtworks.academy;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PersonTest {
    private ByteArrayOutputStream outContent;
    private Person tom;

    @Before
    public void setUp() throws Exception {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        tom = new Person("tom", 100, 10);
    }

    @Test
    public void testAttack() throws Exception {

        Person bob = mock(Person.class);
        tom.attack(bob);

        verify(bob, times(1)).beenAttack(10);
    }

    @Test
    public void testBeenAttack() throws Exception {

        tom.beenAttack(60);
        assertThat(outContent.toString(), is(""));

        tom.beenAttack(60);
        assertThat(outContent.toString(), is("tom被打败了.\n"));
    }

    @Test
    public void testIsDead() throws Exception {

        assertThat(tom.isDead(), is(false));

        tom.beenAttack(50);
        assertThat(tom.isDead(), is(false));

        tom.beenAttack(50);
        assertThat(tom.isDead(), is(true));
    }
}
