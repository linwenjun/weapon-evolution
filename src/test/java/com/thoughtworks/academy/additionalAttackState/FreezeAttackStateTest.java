package com.thoughtworks.academy.additionalAttackState;

import com.thoughtworks.academy.GameMessage;
import com.thoughtworks.academy.player.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Map;

import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FreezeAttackAdditionalState.class)
public class FreezeAttackStateTest {
    FreezeAttackAdditionalState freezeAttackState;
    @Before
    public void setUp() throws Exception {

        freezeAttackState = new FreezeAttackAdditionalState();
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testActOnReceiver() throws Exception {

        Player tom = mock(Player.class);
        whenNew(GameMessage.class).withAnyArguments().thenReturn(mock(GameMessage.class));

        freezeAttackState.actOnReceiver(tom);
        freezeAttackState.actOnReceiver(tom);
        freezeAttackState.actOnReceiver(tom);
        freezeAttackState.actOnReceiver(tom);
        freezeAttackState.actOnReceiver(tom);
        freezeAttackState.actOnReceiver(tom);

        verify(tom, times(3)).lock();
        verifyNew(GameMessage.class, times(3)).withArguments(eq("attackWithFreeze"), any(Map.class));
        verify(tom, times(1)).attachAttackState(any(BlankAttackState.class));

        freezeAttackState.actOnReceiver(tom);
        freezeAttackState.actOnReceiver(tom);
        freezeAttackState.actOnReceiver(tom);

        verify(tom, times(3)).lock();
        verifyNew(GameMessage.class, times(3)).withArguments(eq("attackWithFreeze"), any(Map.class));
    }
}