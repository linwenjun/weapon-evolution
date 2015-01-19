package com.thoughtworks.academy.equipment;

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
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest(RageDiamond.class)
public class RageDiamondTest {

    private Player tom;
    private Player bob;
    private RageDiamond rageDiamond;
    private Weapon sword;

    @Before
    public void setUp() throws Exception {
        rageDiamond = new RageDiamond();
        tom = mock(Player.class);
        bob = mock(Player.class);
        sword = mock(Weapon.class);

        Publisher.getInstance().removeAll();
    }

    @Test
    public void testActOnReceiver() throws Exception {
        IListener listener = mock(IListener.class);
        GameMessage gameMessage = mock(GameMessage.class);

        Publisher.getInstance().addListener(listener);
        when(tom.getAttack()).thenReturn(31);
        when(bob.getDefense()).thenReturn(5);
        when(sword.getName()).thenReturn("sword");
        when(tom.getWeapon()).thenReturn(sword);

        whenNew(GameMessage.class).withAnyArguments().thenReturn(gameMessage);

        rageDiamond.actOnPlayers(tom, bob);

        verify(tom).consumeEnergy();
        verify(bob).beenAttack(3 * (31 - 5));
        verifyNew(GameMessage.class);
    }
}