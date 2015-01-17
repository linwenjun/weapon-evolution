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
    public void testSayAttacked() throws Exception {

        IListener speaker = new Speaker();
        Map<String, String> info = new HashMap<String, String>();
        info.put("name", "tom");
        speaker.update(new GameMessage("die", info));

        assertThat(outContent.toString(), is("tom被打败了。\n"));
    }

    @Test
    public void testSayUpdateBlood() throws Exception {

        IListener speaker = new Speaker();
        Map<String, String> info = new HashMap<String, String>();
        info.put("name", "tom");
        info.put("blood", "100");
        speaker.update(new GameMessage("updateBlood", info));

        assertThat(outContent.toString(), is("tom剩余生命：100\n"));
    }

    @Test
    public void testSayAttack() throws Exception {
        IListener speaker = new Speaker();
        Map<String, String> info = new HashMap<String, String>();
        info.put("provider", "tom");
        info.put("receiver", "bob");
        info.put("providerCareer", "普通人");
        info.put("receiverCareer", "普通人");
        speaker.update(new GameMessage("attack", info));

        assertThat(outContent.toString(), is("普通人tom攻击了普通人bob,"));
    }

    @Test
    public void testSayBeenAttack() throws Exception {

        IListener speaker = new Speaker();
        Map<String, String> info = new HashMap<String, String>();
        info.put("name", "tom");
        info.put("hurt", "100");
        speaker.update(new GameMessage("beenAttack", info));

        assertThat(outContent.toString(), is("tom受到了100点伤害,"));
    }

    @Test
    public void testSayNotExistedPattern() throws Exception {

        IListener speaker = new Speaker();
        Map<String, String> info = new HashMap<String, String>();
        speaker.update(new GameMessage("notExist", info));

        assertThat(outContent.toString(), is(""));
    }
}
