package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.Player;
import com.thoughtworks.academy.attack.FreezeStateAttack;

import java.util.Random;

public class FreezeDiamond implements IDiamond{

    private static final double OCCUR_RATE = 0.25;

    @Override
    public void actOnPlayers(Player provider, Player receiver) {
        Random random = new Random();

        if(random.nextDouble() < OCCUR_RATE) {
            receiver.addStateAttack(new FreezeStateAttack());
        }
    }
}
