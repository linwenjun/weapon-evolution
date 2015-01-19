package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.additionalAttackState.FreezeAttackAdditionalState;

public class FreezeDiamond extends AbstractDiamond {

    @Override
    protected void actOnReceiver() {
        receiver.addStateAttack(new FreezeAttackAdditionalState());
    }

    @Override
    public String getType() {
        return "Freeze";
    }
}
