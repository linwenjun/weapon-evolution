package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.player.Player;

public abstract class IDiamond {
    protected Player provider;
    protected Player receiver;

    public final void actOnPlayers(Player provider, Player receiver) {
        this.provider = provider;
        this.receiver = receiver;
        actOnProvider();
        actOnReceiver();
    }

    protected abstract void actOnReceiver();

    protected void actOnProvider() {
    }

    public abstract String getType();
}

