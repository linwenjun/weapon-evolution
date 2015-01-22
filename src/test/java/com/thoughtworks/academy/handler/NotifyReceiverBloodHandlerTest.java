package com.thoughtworks.academy.handler;

import com.thoughtworks.academy.GameMessage;
import com.thoughtworks.academy.IListener;
import com.thoughtworks.academy.player.OrdinaryPlayer;
import com.thoughtworks.academy.Publisher;
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
@PrepareForTest(NotifyReceiverBloodHandler.class)
public class NotifyReceiverBloodHandlerTest {

    NotifyReceiverBloodHandler handler;
    OrdinaryPlayer tom;
    OrdinaryPlayer bob;

    @Before
    public void setUp() throws Exception {
        handler = new NotifyReceiverBloodHandler(null);
        tom = mock(OrdinaryPlayer.class);
        bob = mock(OrdinaryPlayer.class);
    }



    @Test
    public void testActOnPlayers() throws Exception {
        IListener listener = mock(IListener.class);
        GameMessage gamemessage =  mock(GameMessage.class);
        Publisher.getInstance().addListener(listener);

        whenNew(GameMessage.class).withAnyArguments().thenReturn(gamemessage);
        when(tom.isDead()).thenReturn(false);
        when(tom.isLocked()).thenReturn(false);

        handler.actOnPlayers(tom, bob);

        verifyNew(GameMessage.class).withArguments(eq("updateBlood"), any(Map.class));
        verify(listener, times(1)).update(gamemessage);
    }
}
