package com.thoughtworks.academy.handler;

import com.thoughtworks.academy.attachment.FireStateAttack;
import com.thoughtworks.academy.Player;

public class AdditionalAttackHandler extends GameHandler {

    public AdditionalAttackHandler(GameHandler successor) {
        super(successor);
    }

    @Override
    protected void actOnPlayers(Player provider, Player receiver) {
        receiver.addStateAttack(new FireStateAttack());
    }
}
