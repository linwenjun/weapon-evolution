package com.thoughtworks.academy;

import com.thoughtworks.academy.handler.GameHandler;

public class Turn {
    private GameHandler handler;

    public Turn(GameHandler handler) {
        this.handler = handler;
    }

    public void process(Player provider, Player receiver) {
        handler.actOn(provider, receiver);
        provider.unlock();
    }
}
