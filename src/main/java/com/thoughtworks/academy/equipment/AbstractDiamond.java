package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.Player;

public abstract class AbstractDiamond {
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

