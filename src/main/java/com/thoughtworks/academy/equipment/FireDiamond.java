package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.additionalAttackState.FireAttackAdditionalState;

public class FireDiamond extends IDiamond {

    @Override
    protected void actOnReceiver() {
        receiver.attachAttackState(new FireAttackAdditionalState());
    }

    @Override
    public String getType() {
        return "Fire";
    }
}
