package com.thoughtworks.academy.handler;

import com.thoughtworks.academy.Player;

public class StateAttackHandler extends  GameHandler{

    public StateAttackHandler(GameHandler successor) {
        super(successor);
    }

    @Override
    protected void actOnPlayers(Player provider, Player receiver) {
        provider.releaseStateAttack();
    }
}
