package com.thoughtworks.academy.attack;

import com.thoughtworks.academy.GameMessage;
import com.thoughtworks.academy.IListener;
import com.thoughtworks.academy.Player;
import com.thoughtworks.academy.Publisher;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class FireStateAttackTest {

    @Before
    public void setUp() throws Exception {
        Publisher.getInstance().removeAll();
    }

    @Test
    public void testNewFireStateAttack() throws Exception {
        StateAttack fireStateAttack = new FireStateAttack();
        assertThat(fireStateAttack.getType(), is("Fire"));
    }

    @Test
    public void testFireStateAttack() throws Exception {

        StateAttack fireStateAttack = new FireStateAttack();


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

    @Test
    public void testPublishGameMessage() throws Exception {
        IListener listener = mock(IListener.class);
        Player tom = mock(Player.class);
        StateAttack fireStateAttack = new FireStateAttack();

        Publisher.getInstance().addListener(listener);
        fireStateAttack.actOnReceiver(tom);
        verify(listener, times(1)).update(any(GameMessage.class));
    }
}