package com.thoughtworks.academy.handler;

import com.thoughtworks.academy.player.OrdinaryPlayer;

public abstract class GameHandler {
    protected GameHandler successor;

    public GameHandler(GameHandler successor) {
        this.successor = successor;
    }

    public final void actOn(OrdinaryPlayer provider, OrdinaryPlayer receiver) {
        this.actOnPlayers(provider, receiver);

        if (null != successor) {
            successor.actOn(provider, receiver);
        }
    }

    protected abstract void actOnPlayers(OrdinaryPlayer provider, OrdinaryPlayer receiver);
}
