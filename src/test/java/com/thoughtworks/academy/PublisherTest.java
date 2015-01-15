package com.thoughtworks.academy;

import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PublisherTest {

    @Test
    public void testPublisher() throws Exception {
        Publisher publisher = new Publisher();
        IListener listener1 = mock(IListener.class);
        IListener listener2 = mock(IListener.class);

        publisher.addListener(listener1);
        publisher.addListener(listener2);
        publisher.notifyListeners(new GameMessage("any", null));

        verify(listener1, times(1)).update(any(GameMessage.class));
        verify(listener2, times(1)).update(any(GameMessage.class));
    }

}
