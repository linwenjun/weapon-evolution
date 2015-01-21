package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.additionalAttackState.FreezeAttackAdditionalState;

public class FreezeDiamond extends IDiamond {

    @Override
    protected void actOnReceiver() {
        receiver.attachAttackState(new FreezeAttackAdditionalState());
    }

    @Override
    public String getType() {
        return "Freeze";
    }
}
