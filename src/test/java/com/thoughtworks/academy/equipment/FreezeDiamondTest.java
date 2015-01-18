package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.Player;
import com.thoughtworks.academy.attack.FreezeStateAttack;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Random;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FreezeDiamond.class)
public class FreezeDiamondTest {

    FreezeDiamond freezeDiamond;

    @Before
    public void setUp() throws Exception {

        freezeDiamond = new FreezeDiamond();
    }

    @Test
    public void testActOnReceiver() throws Exception {
        Player tom = mock(Player.class);
        Random random = mock(Random.class);
        when(random.nextDouble()).thenReturn(0.1);
        whenNew(Random.class).withNoArguments().thenReturn(random);

        freezeDiamond.actOnReceiver(tom);
        verifyNew(Random.class).withNoArguments();
        verify(tom, times(1)).addStateAttack(any(FreezeStateAttack.class));
    }

    @Test
    public void testActOnReceiverWhenRateBiggerThan25() throws Exception {
        Player tom = mock(Player.class);
        Random random = mock(Random.class);
        when(random.nextDouble()).thenReturn(0.25);
        whenNew(Random.class).withNoArguments().thenReturn(random);

        freezeDiamond.actOnReceiver(tom);
        verifyNew(Random.class).withNoArguments();
        verify(tom, never()).addStateAttack(any(FreezeStateAttack.class));
    }
}