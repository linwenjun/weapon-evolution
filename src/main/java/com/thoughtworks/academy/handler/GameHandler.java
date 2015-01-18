package com.thoughtworks.academy.handler;

import com.thoughtworks.academy.Player;

public abstract class GameHandler {
    protected GameHandler successor;

    public GameHandler(GameHandler successor) {
        this.successor = successor;
    }

    public void actOn(Player provider, Player receiver) {
        this.actOnPlayers(provider, receiver);

        if (null != successor) {
            successor.actOn(provider, receiver);
        }
    }

    protected abstract void actOnPlayers(Player provider, Player receiver);
}
