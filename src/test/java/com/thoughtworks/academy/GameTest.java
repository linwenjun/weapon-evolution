package com.thoughtworks.academy;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {

    private ByteArrayOutputStream outContent;

    @Before
    public void setUp() throws Exception {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testNewGame() throws Exception {

        Person tom = mock(Person.class);
        Person bob = mock(Person.class);

        when(tom.isLive()).thenReturn(true).thenReturn(false);
        when(bob.isLive()).thenReturn(true).thenReturn(true);
        when(tom.getName()).thenReturn("tom");

        new Game(tom, bob);

        assertThat(outContent.toString(), containsString("tom被击败了"));
    }
}
