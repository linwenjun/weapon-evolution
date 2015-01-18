package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.Player;
import com.thoughtworks.academy.attack.FreezeStateAttack;

public class FreezeDiamond extends AbstractDiamond {

    @Override
    protected void actOnReceiver(Player receiver) {
        receiver.addStateAttack(new FreezeStateAttack());
    }
}
