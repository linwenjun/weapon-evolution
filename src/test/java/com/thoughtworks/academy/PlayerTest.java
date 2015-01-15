package com.thoughtworks.academy;

import org.junit.Test;

import static junit.framework.TestCase.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PlayerTest {

    @Test
    public void testBasicFunctionOfPlayer() throws Exception {
        Player tom = new Player("tom", 100, 25);

        assertThat(tom.getName(), is("tom"));
        assertThat(tom.getCareer(), is("普通人"));
        assertThat(tom.getBlood(), is(100));
        assertThat(tom.getAttack(), is(25));

        assertNull(tom.getWeapon());
    }

    @Test
    public void testPlayerConstructorWithName() throws Exception {
        Player tom = new Player("tom");

        assertThat(tom.getName(), is("tom"));
        assertThat(tom.getCareer(), is("普通人"));
        assertThat(100, is(tom.getBlood()));
        assertThat(10, is(tom.getAttack()));
    }

    @Test
    public void testPlayerWithName() throws Exception {
        Player player = new Player("tom", 100, 10);
        player.beenAttack(20);
        assertThat(80, is(player.getBlood()));
    }

    @Test
    public void testUpdateWhenBeenAttack() throws Exception {
        Player tom = new Player("tom");
        IListener speaker1 = mock(Speaker.class);
        IListener speaker2 = mock(Speaker.class);
        tom.addListener(speaker1);
        tom.addListener(speaker2);
        tom.beenAttack(50);
        verify(speaker1, times(1)).update(any(GameMessage.class));
        verify(speaker2, times(1)).update(any(GameMessage.class));
    }

    @Test
    public void testUpdateTwoTimesMessageWhenDied() throws Exception {
        Player tom = new Player("tom");
        IListener speaker1 = mock(Speaker.class);
        IListener speaker2 = mock(Speaker.class);
        tom.addListener(speaker1);
        tom.addListener(speaker2);
        tom.beenAttack(100);
        verify(speaker1, times(2)).update(any(GameMessage.class));
        verify(speaker2, times(2)).update(any(GameMessage.class));
    }
}