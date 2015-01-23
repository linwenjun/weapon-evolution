package com.thoughtworks.academy;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class GameTest {

    private ByteArrayOutputStream outContent;

    @Before
    public void setUp() throws Exception {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testNewGameWillPrintString() throws Exception {

        Person tom = new Person("tom", 100, 30);
        Person bob = new Person("bob", 80, 25);

        new Game(tom, bob);

        assertThat(outContent.toString(), containsString("bob被击败了"));
    }

    @Test
    public void testNewGameWillExecuteAttack() throws Exception {

        Person tom = new Person("tom", 100, 30);
        Person bob = new Person("bob", 80, 25);
        tom = spy(tom);
        bob = spy(bob);

        new Game(tom, bob);

        verify(tom, times(3)).attack(bob);
        verify(bob, times(2)).attack(tom);
    }
}
