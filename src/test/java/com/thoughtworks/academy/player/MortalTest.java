package com.thoughtworks.academy.player;

import com.thoughtworks.academy.GameMessage;
import com.thoughtworks.academy.IListener;
import com.thoughtworks.academy.Publisher;
import com.thoughtworks.academy.additionalAttackState.AdditionalAttackState;
import com.thoughtworks.academy.additionalAttackState.BlankAttackState;
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
@PrepareForTest(Mortal.class)
public class MortalTest {

    Mortal tom;

    @Before
    public void setUp() throws Exception {
        tom = new Mortal("tom");

    }

    @After
    public void tearDown() throws Exception {

        Publisher.getInstance().removeAll();
    }

    @Test
    public void testBasicFunctionOfPlayer() throws Exception {
        BlankAttackState blankAttackState = mock(BlankAttackState.class);
        whenNew(BlankAttackState.class).withNoArguments().thenReturn(blankAttackState);

        Mortal tom = new Mortal("tom", 100, 25);
        tom.setDefense(10);

        assertThat(tom.getName(), is("tom"));
        assertThat(tom.getCareer(), is("普通人"));
        assertThat(tom.getBlood(), is(100));
        assertThat(tom.getAttack(), is(25));
        assertThat(tom.getDefense(), is(0));
        assertThat(tom.getWeapon(), is(nullValue()));
        assertThat(tom.getAttackState(), is((AdditionalAttackState)blankAttackState));
    }

    @Test
    public void testPlayerConstructorWithName() throws Exception {
        Mortal tom = new Mortal("tom");

        assertThat(tom.getName(), is("tom"));
        assertThat(tom.getCareer(), is("普通人"));
        assertThat(100, is(tom.getBlood()));
        assertThat(10, is(tom.getAttack()));
    }

    @Test
    public void testPlayerWithName() throws Exception {
        Mortal player = new Mortal("tom", 100, 10);
        player.beenAttack(20);
        assertThat(80, is(player.getBlood()));
    }

    @Test
    public void testUpdateWhenBeenAttack() throws Exception {
        Mortal tom = new Mortal("tom");
        IListener listener = mock(IListener.class);
        Publisher.getInstance().addListener(listener);

        tom.beenAttack(50);
        verify(listener, never()).update(any(GameMessage.class));
    }


    @Test
    public void testPlayerLock() throws Exception {

        Mortal tom = new Mortal("tom");
        assertThat(tom.isLocked(), is(false));
        tom.lock();
        assertThat(tom.isLocked(), is(true));
        tom.unlock();
        assertThat(tom.isLocked(), is(false));
    }

    @Test
    public void testEnergy() throws Exception {
        Mortal tom = new Mortal("tom");

        assertThat(tom.hasEnergy(), is(true));
        tom.consumeEnergy();
        assertThat(tom.hasEnergy(), is(false));
        tom.giveEnergy();
        assertThat(tom.hasEnergy(), is(true));
    }

    @Test
    public void testAddStateAttack() throws Exception {
        AdditionalAttackState additionalAttackState = mock(AdditionalAttackState.class);
        when(additionalAttackState.getType()).thenReturn("Fire");
        whenNew(GameMessage.class).withAnyArguments().thenReturn(mock(GameMessage.class));

        tom.attachAttackState(additionalAttackState);
        verifyNew(GameMessage.class).withArguments(eq("beenAttackByFire"), any(Map.class));
    }

    @Test
    public void testAddStateFreezeAttack() throws Exception {
        AdditionalAttackState additionalAttackState = mock(AdditionalAttackState.class);
        when(additionalAttackState.getType()).thenReturn("Freeze");
        whenNew(GameMessage.class).withAnyArguments().thenReturn(mock(GameMessage.class));

        tom.attachAttackState(additionalAttackState);
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