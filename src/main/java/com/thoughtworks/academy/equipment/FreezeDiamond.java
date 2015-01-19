package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.additionalAttackState.FreezeStateAttack;

public class FreezeDiamond extends AbstractDiamond {

    @Override
    protected void actOnReceiver() {
        receiver.addStateAttack(new FreezeStateAttack());
    }

    @Override
    public String getType() {
        return "Freeze";
    }
}
