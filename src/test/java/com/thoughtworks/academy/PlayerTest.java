package com.thoughtworks.academy;

import com.thoughtworks.academy.equipment.Weapon;
import org.junit.After;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class PlayerTest {

    @After
    public void tearDown() throws Exception {

        Publisher.getInstance().removeAll();
    }

    @Test
    public void testBasicFunctionOfPlayer() throws Exception {
        Player tom = new Player("tom", 100, 25);
        tom.setDefense(10);

        assertThat(tom.getName(), is("tom"));
        assertThat(tom.getCareer(), is("普通人"));
        assertThat(tom.getBlood(), is(100));
        assertThat(tom.getAttack(), is(25));
        assertThat(tom.getDefense(), is(0));
        assertThat(tom.getWeapon(), is(nullValue()));
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
        IListener listener = mock(IListener.class);
        Publisher.getInstance().addListener(listener);

        tom.beenAttack(50);
        verify(listener, times(1)).update(any(GameMessage.class));
    }

    @Test
    public void testUpdateTwoTimesMessageWhenDied() throws Exception {
        Player tom = new Player("tom");
        IListener listener = mock(IListener.class);
        Publisher.getInstance().addListener(listener);

        tom.beenAttack(500);
        verify(listener, times(2)).update(any(GameMessage.class));
    }

    @Test
    public void testPlayerWithWeapon() throws Exception {
        Soldier tom = new Soldier("tom");
        Weapon weapon = mock(Weapon.class);

        tom.setWeapon(weapon);

        assertThat(tom.getWeapon(), is(weapon));
    }
}