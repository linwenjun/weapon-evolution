package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(RageDiamond.class)
public class RageDiamondTest {

    private Player tom;
    private Player bob;
    private RageDiamond rageDiamond;
    private Random random;

    @Before
    public void setUp() throws Exception {

        tom = mock(Player.class);
        bob = mock(Player.class);
        random = mock(Random.class);
        rageDiamond = new RageDiamond();
    }

    @Test
    public void testActOnProvider() throws Exception {
        rageDiamond.actOnPlayers(tom, bob);
        rageDiamond.actOnProvider();
        verify(tom).consumeEnergy();
    }

    @Test
    public void testActOnReceiver() throws Exception {
        rageDiamond.actOnPlayers(tom, bob);
        when(tom.getAttack()).thenReturn(31);
        when(bob.getDefense()).thenReturn(5);

        rageDiamond.actOnReceiver();

        verify(bob).beenAttack(3 * (31 - 5));
    }
}