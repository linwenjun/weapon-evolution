package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.player.OrdinaryPlayer;

public abstract class IDiamond {
    protected OrdinaryPlayer provider;
    protected OrdinaryPlayer receiver;

    public final void actOnPlayers(OrdinaryPlayer provider, OrdinaryPlayer receiver) {
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

