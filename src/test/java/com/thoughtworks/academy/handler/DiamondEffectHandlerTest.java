package com.thoughtworks.academy.handler;

import com.thoughtworks.academy.player.Mortal;
import com.thoughtworks.academy.equipment.IDiamond;
import com.thoughtworks.academy.equipment.FireDiamond;
import com.thoughtworks.academy.equipment.Weapon;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class DiamondEffectHandlerTest {

    @Test
    public void testActOnPlayers() throws Exception {

        GameHandler handler = new DiamondEffectHandler(null);
        Weapon sword = mock(Weapon.class);
        Mortal tom = mock(Mortal.class);
        Mortal bob = mock(Mortal.class);
        IDiamond diamond = mock(FireDiamond.class);

        when(bob.getWeapon()).thenReturn(sword);
        when(sword.getEffectiveDiamond()).thenReturn(diamond);

        handler.actOnPlayers(bob, tom);

        verify(diamond, times(1)).actOnPlayers(bob, tom);
    }
}