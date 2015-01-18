package com.thoughtworks.academy;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class PublisherTest {

    @Test
    public void testPublisher() throws Exception {
        Publisher publisher = Publisher.getInstance();
        IListener listener1 = mock(IListener.class);
        IListener listener2 = mock(IListener.class);

        publisher.addListener(listener1);
        publisher.addListener(listener2);
        publisher.notifyListeners(new GameMessage("any", null));

        verify(listener1, times(1)).update(any(GameMessage.class));
        verify(listener2, times(1)).update(any(GameMessage.class));
    }

    @Test
    public void testPublisherIsSingletons() throws Exception {
        Publisher publisher = Publisher.getInstance();
        Publisher publisher1 = Publisher.getInstance();
        assertThat(publisher, is(publisher1));
    }

    @Test
    public void testPublisherRemoveAllListeners() throws Exception {
        Publisher publisher = Publisher.getInstance();
        IListener listener1 = mock(IListener.class);
        IListener listener2 = mock(IListener.class);

        publisher.addListener(listener1);
        publisher.addListener(listener2);
        publisher.removeAll();
        publisher.notifyListeners(new GameMessage("any", null));
        verify(listener1, never()).update(any(GameMessage.class));
        verify(listener2, never()).update(any(GameMessage.class));
    }
}
