package com.thoughtworks.academy;

import com.thoughtworks.academy.attack.StateAttack;
import com.thoughtworks.academy.equipment.Weapon;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Player.class)
public class PlayerTest {

    Player tom;

    @Before
    public void setUp() throws Exception {
        tom = new Player("tom");

    }

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
        verify(listener, never()).update(any(GameMessage.class));
    }

    @Test
    public void testPlayerWithWeapon() throws Exception {
        Soldier tom = new Soldier("tom");
        Weapon weapon = mock(Weapon.class);

        tom.setWeapon(weapon);

        assertThat(tom.getWeapon(), is(weapon));
    }

    @Test
    public void testPlayerLock() throws Exception {

        Player tom = new Player("tom");
        assertThat(tom.isLocked(), is(false));
        tom.lock();
        assertThat(tom.isLocked(), is(true));
        tom.unlock();
        assertThat(tom.isLocked(), is(false));
    }

    @Test
    public void testEnergy() throws Exception {
        Player tom = new Player("tom");

        assertThat(tom.hasEnergy(), is(true));
        tom.consumeEnergy();
        assertThat(tom.hasEnergy(), is(false));
        tom.giveEnergy();
        assertThat(tom.hasEnergy(), is(true));
    }

    @Test
    public void testAddStateAttack() throws Exception {
        StateAttack stateAttack = mock(StateAttack.class);
        when(stateAttack.getType()).thenReturn("Fire");
        whenNew(GameMessage.class).withAnyArguments().thenReturn(mock(GameMessage.class));

        tom.addStateAttack(stateAttack);
        verifyNew(GameMessage.class).withArguments(eq("beenAttackByFire"), any(Map.class));
    }

    @Test
    public void testAddStateFreezeAttack() throws Exception {
        StateAttack stateAttack = mock(StateAttack.class);
        when(stateAttack.getType()).thenReturn("Freeze");
        whenNew(GameMessage.class).withAnyArguments().thenReturn(mock(GameMessage.class));

        tom.addStateAttack(stateAttack);
        verifyNew(GameMessage.class).withArguments(eq("beenAttackByFreeze"), any(Map.class));
    }

    @Test
    public void testIsExhaustedWhenConsumeEnergy() throws Exception {

        assertThat(tom.isExhausted(), is(false));
        tom.consumeEnergy();
        assertThat(tom.isExhausted(), is(true));
        tom.giveEnergy();

        assertThat(tom.isExhausted(), is(false));
        tom.lock();
        assertThat(tom.isExhausted(), is(true));
        tom.unlock();
        assertThat(tom.isExhausted(), is(false));

        tom.beenAttack(100);
        assertThat(tom.isExhausted(), is(true));
    }
}