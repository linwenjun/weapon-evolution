package com.thoughtworks.academy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MessageTest {

    @Test
    public void testNewMessage() throws Exception {
        Map<String, String> infoMap = new HashMap<String, String>();

        GameMessage message = new GameMessage("die", infoMap);

        assertThat(message.getType(), is("die"));
        assertThat(message.getInfo(), is(infoMap));
    }
}
