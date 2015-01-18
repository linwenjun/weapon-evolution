package com.thoughtworks.academy.handler;

import com.thoughtworks.academy.GameMessage;
import com.thoughtworks.academy.Player;
import com.thoughtworks.academy.Publisher;

import java.util.HashMap;
import java.util.Map;

public class PhysicalAttackHandler extends GameHandler {

    public PhysicalAttackHandler(GameHandler successor) {
        super(successor);
    }

    protected void actOnPlayers(Player provider, Player receiver) {
        if (provider.isDead() || receiver.isDead() || provider.isLocked()) {
            return;
        }

        int hurtValue = provider.getAttack();

        if (null != provider.getWeapon()) {
            hurtValue += provider.getWeapon().getAttackValue();
        }

        updateMessage(provider, receiver);
        receiver.beenAttack(hurtValue);
    }

    private void updateMessage(Player provider, Player receiver) {
        GameMessage gameMessage;

        Map<String, String> info = new HashMap<String, String>();
        info.put("providerCareer", provider.getCareer());
        info.put("provider", "" + provider.getName());
        info.put("receiverCareer", "" + receiver.getCareer());
        info.put("receiver", "" + receiver.getName());

        if (null != provider.getWeapon()) {
            info.put("weapon", provider.getWeapon().getName());
            gameMessage = new GameMessage("attackWithWeapon", info);
        } else {
            gameMessage = new GameMessage("attack", info);
        }
        Publisher.getInstance().notifyListeners(gameMessage);
    }
}
