package com.thoughtworks.academy.handler;

import com.thoughtworks.academy.GameMessage;
import com.thoughtworks.academy.player.Player;
import com.thoughtworks.academy.Publisher;

import java.util.HashMap;
import java.util.Map;

public class StateAttackHandler extends GameHandler {

    public StateAttackHandler(GameHandler successor) {
        super(successor);
    }

    @Override
    protected void actOnPlayers(Player provider, Player receiver) {
        provider.releaseStateAttack();

        if (provider.isDead()) {
            Map<String, String> info = new HashMap<String, String>();
            info.put("name", provider.getName());
            Publisher.getInstance().notifyListeners(new GameMessage("die", info));
        }
    }
}
