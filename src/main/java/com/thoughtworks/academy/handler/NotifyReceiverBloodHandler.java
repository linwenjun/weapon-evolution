package com.thoughtworks.academy.handler;

import com.thoughtworks.academy.GameMessage;
import com.thoughtworks.academy.player.OrdinaryPlayer;
import com.thoughtworks.academy.Publisher;

import java.util.HashMap;
import java.util.Map;

public class NotifyReceiverBloodHandler extends GameHandler {

    public NotifyReceiverBloodHandler(GameHandler successor) {
        super(successor);
    }

    @Override
    protected void actOnPlayers(OrdinaryPlayer provider, OrdinaryPlayer receiver) {

        Map<String, String> info = new HashMap<String, String>();
        info.put("name", receiver.getName());
        info.put("blood", "" + receiver.getBlood());

        if(!provider.isDead() && !provider.isLocked()) {
            Publisher.getInstance().notifyListeners(new GameMessage("updateBlood", info));
        }

        if(receiver.isDead()) {
            Publisher.getInstance().notifyListeners(new GameMessage("die", info));
        }
    }
}
