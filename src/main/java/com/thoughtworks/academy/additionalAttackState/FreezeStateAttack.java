package com.thoughtworks.academy.additionalAttackState;

import com.thoughtworks.academy.GameMessage;
import com.thoughtworks.academy.Player;
import com.thoughtworks.academy.Publisher;

import java.util.HashMap;
import java.util.Map;

public class FreezeStateAttack extends StateAttack {
    private int fightCount;
    private int limitCount;
    private int count;

    public FreezeStateAttack() {
        count = 0;
        fightCount = 0;
        limitCount = 3;
    }

    @Override
    public String getType() {
        return "Freeze";
    }

    @Override
    public StateAttack update(StateAttack stateAttack) {
        limitCount += limitCount;
        return this;
    }

    @Override
    public void actOnReceiver(Player receiver) {
        if(fightCount >= limitCount) {
            return;
        }

        if(0 == count % 2) {
            receiver.lock();

            Map<String, String> info = new HashMap<String, String>();
            info.put("receiver", receiver.getName());
            info.put("blood", receiver.getBlood() + "");
            Publisher.getInstance().notifyListeners(new GameMessage("attackWithFreeze", info));

            fightCount++;
        }

        count++;

        if(fightCount >= limitCount) {
            receiver.addStateAttack(null);
        }
    }
}
