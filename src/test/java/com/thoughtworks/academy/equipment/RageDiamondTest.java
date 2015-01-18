package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.Player;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class RageDiamondTest {

    private Player tom;
    private Player bob;
    private RageDiamond rageDiamond;

    @Before
    public void setUp() throws Exception {

        tom = mock(Player.class);
        bob = mock(Player.class);
        rageDiamond = new RageDiamond();
    }

    @Test
    public void testActOnPlayers() throws Exception {

        rageDiamond.actOnPlayers(tom, bob);
    }
}