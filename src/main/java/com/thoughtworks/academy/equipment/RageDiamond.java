package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.GameMessage;
import com.thoughtworks.academy.Publisher;

import java.util.HashMap;
import java.util.Map;

public class RageDiamond extends IDiamond {

    @Override
    protected void actOnProvider() {
        provider.consumeEnergy();
    }

    @Override
    public String getType() {
        return "Rage";
    }

    @Override
    protected void actOnReceiver() {
        int hurtValue = getHurtValue();
        receiver.beenAttack(hurtValue);

        Map<String, String> info = new HashMap<String, String>();
        info.put("provider", provider.getName());
        info.put("receiver", receiver.getName());
        info.put("fullNameOfProvider", provider.getCareer() + provider.getName());
        info.put("fullNameOfReceiver", receiver.getCareer() + receiver.getName());
        info.put("hurtValue", hurtValue + "");
        info.put("weapon", provider.getWeapon().getName());

        GameMessage gameMessage = new GameMessage("rageAttack", info);
        Publisher.getInstance().notifyListeners(gameMessage);
    }

    private int getHurtValue() {
        return 3 * (provider.getAttack() + provider.getWeapon().getAttackValue() - receiver.getDefense());
    }
}
