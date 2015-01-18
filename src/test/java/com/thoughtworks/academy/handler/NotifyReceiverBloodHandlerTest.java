package com.thoughtworks.academy.handler;

import com.thoughtworks.academy.GameMessage;
import com.thoughtworks.academy.IListener;
import com.thoughtworks.academy.Player;
import com.thoughtworks.academy.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest(NotifyReceiverBloodHandler.class)
public class NotifyReceiverBloodHandlerTest {

    NotifyReceiverBloodHandler handler;
    Player tom;
    Player bob;

    @Before
    public void setUp() throws Exception {
        handler = new NotifyReceiverBloodHandler(null);
        tom = mock(Player.class);
        bob = mock(Player.class);
    }



    @Test
    public void testActOnPlayers() throws Exception {

        IListener listener = mock(IListener.class);
        GameMessage gamemessage =  mock(GameMessage.class);
        whenNew(GameMessage.class).withAnyArguments().thenReturn(gamemessage);

        Publisher.getInstance().addListener(listener);
        handler.actOnPlayers(tom, bob);
        verify(listener, times(1)).update(gamemessage);
    }
}
