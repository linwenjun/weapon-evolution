package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.Player;
import com.thoughtworks.academy.attack.FireStateAttack;

import java.util.Random;

public class FireDiamond implements IDiamond {
    private final double ATTACH_RATE = 0.25;

    @Override
    public void actOnPlayers(Player provider, Player receiver) {
        Random random = new Random();

        if(random.nextDouble() < ATTACH_RATE) {
            receiver.addStateAttack(new FireStateAttack());
        }
    }
}
