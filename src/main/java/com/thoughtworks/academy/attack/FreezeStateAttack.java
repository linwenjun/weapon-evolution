package com.thoughtworks.academy.attack;

import com.thoughtworks.academy.Player;

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
            fightCount++;
        }

        count++;

        if(fightCount >= limitCount) {
            receiver.addStateAttack(null);
        }
    }
}
