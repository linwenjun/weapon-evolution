package com.thoughtworks.academy;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

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
    public void testField() throws Exception {

        assertThat(tom.getName(), is("tom"));
        assertThat(tom.getHealth(), is(100));
    }

    @Test
    public void testAttack() throws Exception {

        Person bob = mock(Person.class);
        tom.attack(bob);

        verify(bob, times(1)).beenAttack(10);
    }

    @Test
    public void testAttackWithStatement() throws Exception {

        Person bob = new Person("bob", 80, 10);

        tom.attack(bob);

        assertThat(outContent.toString(), is("tom攻击了bob,bob受到了10点伤害,bob剩余生命：70\n"));
    }



    @Test
    public void testBeenAttack() throws Exception {

        tom.beenAttack(60);
        assertThat(tom.getHealth(), is(40));
        assertThat(outContent.toString(), is(""));

        tom.beenAttack(60);
        assertThat(tom.getHealth(), is(-20));
    }

    @Test
    public void testIsDead() throws Exception {

        assertThat(tom.isLive(), is(true));

        tom.beenAttack(50);
        assertThat(tom.isLive(), is(true));

        tom.beenAttack(50);
        assertThat(tom.isLive(), is(false));
    }
}
