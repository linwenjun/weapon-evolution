package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.Player;

import java.util.Random;

public abstract class AbstractDiamond {
    public final void actOnPlayers(Player provider, Player receiver) {
        Random random = new Random();

        if(random.nextDouble() < getAttackRate()) {
            actOnProvider(provider);
            actOnReceiver(receiver);
        }
    }

    private double getAttackRate() {
        return 0.25;
    }

    protected abstract void actOnReceiver(Player receiver);

    protected void actOnProvider(Player provider) {};
}

