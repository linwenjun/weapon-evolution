package com.thoughtworks.academy;

import com.thoughtworks.academy.player.OrdinaryPlayer;
import com.thoughtworks.academy.handler.GameHandler;

public class Turn {
    private GameHandler handler;

    public Turn(GameHandler handler) {
        this.handler = handler;
    }

    public void process(OrdinaryPlayer provider, OrdinaryPlayer receiver) {
        handler.actOn(provider, receiver);

        provider.restore();
    }
}
