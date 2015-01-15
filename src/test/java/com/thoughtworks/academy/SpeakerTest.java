package com.thoughtworks.academy;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SpeakerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testSay() throws Exception {

        IListener speaker = new Speaker();
        Map<String, String> info = new HashMap<String, String>();
        info.put("name", "tom");
        speaker.update(new GameMessage("die", info));

        assertThat(outContent.toString(), is("tom被打败了。\n"));
    }
}
