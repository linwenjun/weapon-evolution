package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.Player;

import java.util.Random;

public abstract class AbstractDiamond {
    private static final double FIGHT_RATE = 0.25;
    protected Player provider;
    protected Player receiver;

    public final void actOnPlayers(Player provider, Player receiver) {
        this.provider = provider;
        this.receiver = receiver;
        Random random = new Random();

        if(random.nextDouble() < FIGHT_RATE) {
            actOnProvider();
            actOnReceiver();
        }
    }

    protected abstract void actOnReceiver();

    protected void actOnProvider() {};
}

