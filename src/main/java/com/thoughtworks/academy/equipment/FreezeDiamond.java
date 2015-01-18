package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.attack.FreezeStateAttack;

public class FreezeDiamond extends AbstractDiamond {

    @Override
    protected void actOnReceiver() {
        receiver.addStateAttack(new FreezeStateAttack());
    }
}
